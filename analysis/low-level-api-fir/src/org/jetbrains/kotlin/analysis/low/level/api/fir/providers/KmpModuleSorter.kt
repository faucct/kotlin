/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir.providers

import org.jetbrains.kotlin.analysis.project.structure.KtModule
import org.jetbrains.kotlin.utils.topologicalSort

/**
 * Sorts modules that belong to the same KMP project: (A dependsOn B) -> (A goes before B).
 * It's necessary to give 'actual' declarations from platform modules higher priority.
 * Preserves positions of other non-KMP modules unchanged to avoid potential side effects.
 * In case of an unexpected error returns the modules unchanged.
 */
class KmpModuleSorter private constructor(private val modules: List<KtModule>) {
    private val groupsByModules = mutableMapOf<KtModule, KmpGroup>()
    private val originalPositions = mutableMapOf<KtModule, Int>()

    // Signals corrupted state. When set, original positions will be used for recovery
    var hasErrors = false
        private set

    private fun sort(): List<KtModule> {
        groupModules()
        val sorted = sortModules()
        return if (hasErrors) modules else sorted
    }

    private fun groupModules() {
        for ((index, module) in modules.withIndex()) {
            originalPositions[module] = index
            val group = findOrCreateKmpGroup(module, groupsByModules)
            group.addModule(module)
            groupsByModules.putIfAbsent(module, group)
            module.directDependsOnDependencies.forEach { dependency -> groupsByModules.putIfAbsent(dependency, group) }
        }
    }

    private fun sortModules(): List<KtModule> {
        val sortedModules = arrayOfNulls<KtModule>(modules.size)
        modules.forEachIndexed { index, module ->
            val group = groupsByModules[module]
            if (group == null) {
                sortedModules[index] = module
            } else {
                sortedModules[group.getUpdatedIndexOf(module)] = module
            }
        }

        return sortedModules.toList().filterNotNull()
    }

    private fun findOrCreateKmpGroup(
        module: KtModule,
        groups: MutableMap<KtModule, KmpGroup>,
    ): KmpGroup {
        groups[module]?.let { return it }
        module.directDependsOnDependencies.firstNotNullOfOrNull { dependency -> groups[dependency] }?.let { return it }
        return KmpGroup()
    }

    private fun getOriginalPositionOrSetCorrupted(module: KtModule): Int {
        val originalPosition = originalPositions[module]
        if (originalPosition == null) hasErrors = true
        return originalPosition ?: 0
    }

    /**
     * Modules, corresponding to source sets of the same KMP project.
     */
    private inner class KmpGroup() {
        private val modules = mutableListOf<KtModule>()
        private val sortedModules by lazy {
            topologicalSort(modules) { directDependsOnDependencies }.also {
                if (it.size != modules.size) hasErrors = true
            }
        }

        private val oldReplacedModulesBySortedModules by lazy { sortedModules.zip(modules).toMap() }

        fun addModule(module: KtModule) {
            modules.add(module)
        }

        fun getUpdatedIndexOf(module: KtModule): Int {
            check(module in modules)
            if (modules.size == 1) return getOriginalPositionOrSetCorrupted(module)

            val newPosition = oldReplacedModulesBySortedModules[module]?.let { getOriginalPositionOrSetCorrupted(it) }
            if (newPosition == null) hasErrors = true

            return newPosition ?: 0
        }

        // N.B.: evaluating debug text before all modules are registered will corrupt the group
        @Suppress("unused")
        fun debugText(): String =
            oldReplacedModulesBySortedModules.entries.joinToString(separator = "; ", prefix = "[", postfix = "]") { (sorted, replaced) ->
                "$sorted -> $replaced (ix -> ix': ${originalPositions[sorted]} -> ${originalPositions[replaced]})"
            }
    }

    companion object {
        fun order(modules: List<KtModule>): List<KtModule> {
            if (modules.size < 2) return modules
            return KmpModuleSorter(modules).sort()
        }
    }
}
