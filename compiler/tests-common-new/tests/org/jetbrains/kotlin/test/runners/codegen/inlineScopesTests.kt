/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.test.runners.codegen

import org.jetbrains.kotlin.test.builders.TestConfigurationBuilder

open class AbstractIrBlackBoxInlineCodegenWithBytecodeInlinerTestWithInlineScopes :
    AbstractIrBlackBoxInlineCodegenWithBytecodeInlinerTest() {
    override fun configure(builder: TestConfigurationBuilder) {
        super.configure(builder)
        builder.useInlineScopesNumbers()
    }
}

open class AbstractIrBlackBoxInlineCodegenWithIrInlinerTestWithInlineScopes : AbstractIrBlackBoxInlineCodegenWithIrInlinerTest() {
    override fun configure(builder: TestConfigurationBuilder) {
        super.configure(builder)
        builder.useInlineScopesNumbers()
    }
}

open class AbstractIrAsmLikeInstructionListingTestWithInlineScopes : AbstractIrAsmLikeInstructionListingTest() {
    override fun configure(builder: TestConfigurationBuilder) {
        super.configure(builder)
        builder.useInlineScopesNumbers()
    }
}

open class AbstractIrBlackBoxCodegenTestWithInlineScopes : AbstractIrBlackBoxCodegenTest() {
    override fun configure(builder: TestConfigurationBuilder) {
        super.configure(builder)
        builder.useInlineScopesNumbers()
    }
}

open class AbstractIrBlackBoxCodegenWithIrInlinerTestWithInlineScopes : AbstractIrBlackBoxCodegenWithIrInlinerTest() {
    override fun configure(builder: TestConfigurationBuilder) {
        super.configure(builder)
        builder.useInlineScopesNumbers()
    }
}

open class AbstractIrBytecodeListingTestWithInlineScopes : AbstractIrBytecodeListingTest() {
    override fun configure(builder: TestConfigurationBuilder) {
        super.configure(builder)
        builder.useInlineScopesNumbers()
    }
}

open class AbstractIrBytecodeTextTestWithInlineScopes : AbstractIrBytecodeTextTest() {
    override fun configure(builder: TestConfigurationBuilder) {
        super.configure(builder)
        builder.useInlineScopesNumbers()
    }
}

open class AbstractIrCompileKotlinAgainstInlineKotlinTestWithInlineScopes : AbstractIrCompileKotlinAgainstInlineKotlinTest() {
    override fun configure(builder: TestConfigurationBuilder) {
        super.configure(builder)
        builder.useInlineScopesNumbers()
    }
}

open class AbstractIrLocalVariableBytecodeInlinerTestWithInlineScopes : AbstractIrLocalVariableBytecodeInlinerTest() {
    override fun configure(builder: TestConfigurationBuilder) {
        super.configure(builder)
        builder.useInlineScopesNumbers()
    }
}

open class AbstractIrLocalVariableIrInlinerTestWithInlineScopes : AbstractIrLocalVariableIrInlinerTest() {
    override fun configure(builder: TestConfigurationBuilder) {
        super.configure(builder)
        builder.useInlineScopesNumbers()
    }
}

open class AbstractIrSerializeCompileKotlinAgainstInlineKotlinTestWithInlineScopes :
    AbstractIrSerializeCompileKotlinAgainstInlineKotlinTest() {
    override fun configure(builder: TestConfigurationBuilder) {
        super.configure(builder)
        builder.useInlineScopesNumbers()
    }
}

open class AbstractIrSteppingWithBytecodeInlinerTestWithInlineScopes : AbstractIrSteppingWithBytecodeInlinerTest() {
    override fun configure(builder: TestConfigurationBuilder) {
        super.configure(builder)
        builder.useInlineScopesNumbers()
    }
}

open class AbstractIrSteppingWithIrInlinerTestWithInlineScopes : AbstractIrSteppingWithBytecodeInlinerTest(useIrInliner = true) {
    override fun configure(builder: TestConfigurationBuilder) {
        super.configure(builder)
        builder.useInlineScopesNumbers()
    }
}
