/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir.test.configurators

import com.intellij.openapi.Disposable
import com.intellij.openapi.project.Project
import org.jetbrains.kotlin.analysis.api.impl.base.test.configurators.AnalysisApiBaseTestServiceRegistrar
import org.jetbrains.kotlin.analysis.api.impl.base.test.configurators.AnalysisApiDecompiledCodeTestServiceRegistrar
import org.jetbrains.kotlin.analysis.api.impl.base.test.configurators.AnalysisApiLibraryBaseTestServiceRegistrar
import org.jetbrains.kotlin.analysis.api.standalone.base.project.structure.KtModuleProjectStructure
import org.jetbrains.kotlin.analysis.api.standalone.base.project.structure.KtModuleWithFiles
import org.jetbrains.kotlin.analysis.low.level.api.fir.compiler.based.SealedClassesInheritorsCaclulatorPreAnalysisHandler
import org.jetbrains.kotlin.analysis.low.level.api.fir.test.base.AnalysisApiFirTestServiceRegistrar
import org.jetbrains.kotlin.analysis.test.framework.project.structure.KtModuleFactory
import org.jetbrains.kotlin.analysis.test.framework.project.structure.TestModuleStructureFactory
import org.jetbrains.kotlin.analysis.test.framework.services.libraries.*
import org.jetbrains.kotlin.analysis.test.framework.services.configuration.AnalysisApiJvmEnvironmentConfigurator
import org.jetbrains.kotlin.analysis.test.framework.services.libraries.compiledLibraryProvider
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfigurator
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestServiceRegistrar
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.FrontendKind
import org.jetbrains.kotlin.platform.isMultiPlatform
import org.jetbrains.kotlin.test.builders.TestConfigurationBuilder
import org.jetbrains.kotlin.test.model.TestModule
import org.jetbrains.kotlin.test.services.TestModuleStructure
import org.jetbrains.kotlin.test.services.TestServices
import org.junit.Assume

object AnalysisApiFirLibrarySourceTestConfigurator : AnalysisApiTestConfigurator() {
    override val analyseInDependentSession: Boolean get() = false
    override val frontendKind: FrontendKind get() = FrontendKind.Fir

    override fun configureTest(
        builder: TestConfigurationBuilder,
        disposable: Disposable
    ) {
        builder.apply {
            useAdditionalService<KtModuleFactory> { KtLibrarySourceModuleFactory() }
            useAdditionalService<TestModuleCompiler> { DispatchingTestModuleCompiler() }
            useDirectives(SealedClassesInheritorsCaclulatorPreAnalysisHandler.Directives)
            usePreAnalysisHandlers(::SealedClassesInheritorsCaclulatorPreAnalysisHandler)
            useConfigurators(::AnalysisApiJvmEnvironmentConfigurator)
        }
    }

    override fun createModules(
        moduleStructure: TestModuleStructure,
        testServices: TestServices,
        project: Project
    ): KtModuleProjectStructure {
        return TestModuleStructureFactory.createProjectStructureByTestStructure(moduleStructure, testServices, project)
    }

    override val serviceRegistrars: List<AnalysisApiTestServiceRegistrar> =
        listOf(
            AnalysisApiBaseTestServiceRegistrar,
            AnalysisApiDecompiledCodeTestServiceRegistrar,
            AnalysisApiFirTestServiceRegistrar,
            AnalysisApiLibraryBaseTestServiceRegistrar,
        )
}

private class KtLibrarySourceModuleFactory : KtModuleFactory {
    override fun createModule(testModule: TestModule, testServices: TestServices, project: Project): KtModuleWithFiles {
        Assume.assumeFalse("Compilation of multi-platform libraries is not supported", testModule.targetPlatform.isMultiPlatform())

        val (libraryJar, librarySourcesJar) = testServices.compiledLibraryProvider.compileToLibrary(testModule)

        require(librarySourcesJar != null)

        return createKtLibrarySourceModule(
            libraryJar = libraryJar,
            librarySourcesJar = librarySourcesJar,
            testModule = testModule,
            project = project,
        )
    }
}