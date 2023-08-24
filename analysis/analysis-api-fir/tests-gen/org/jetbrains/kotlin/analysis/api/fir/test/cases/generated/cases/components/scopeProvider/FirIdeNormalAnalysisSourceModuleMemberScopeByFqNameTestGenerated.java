/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.components.scopeProvider;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.analysis.api.fir.test.configurators.AnalysisApiFirTestConfiguratorFactory;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfiguratorFactoryData;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfigurator;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.TestModuleKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.FrontendKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisSessionMode;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiMode;
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.scopeProvider.AbstractMemberScopeByFqNameTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeNormalAnalysisSourceModuleMemberScopeByFqNameTestGenerated extends AbstractMemberScopeByFqNameTest {
    @NotNull
    @Override
    public AnalysisApiTestConfigurator getConfigurator() {
        return AnalysisApiFirTestConfiguratorFactory.INSTANCE.createConfigurator(
            new AnalysisApiTestConfiguratorFactoryData(
                FrontendKind.Fir,
                TestModuleKind.Source,
                AnalysisSessionMode.Normal,
                AnalysisApiMode.Ide
            )
        );
    }

    @Test
    public void testAllFilesPresentInMemberScopeByFqName() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("dataClass.kt")
    public void testDataClass() throws Exception {
        runTest("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/dataClass.kt");
    }

    @Test
    @TestMetadata("enumEntryInitializer.kt")
    public void testEnumEntryInitializer() throws Exception {
        runTest("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/enumEntryInitializer.kt");
    }

    @Test
    @TestMetadata("enumEntryInitializerWithFinalEnumMember.kt")
    public void testEnumEntryInitializerWithFinalEnumMember() throws Exception {
        runTest("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/enumEntryInitializerWithFinalEnumMember.kt");
    }

    @Test
    @TestMetadata("enumEntryInitializerWithOverriddenMember.kt")
    public void testEnumEntryInitializerWithOverriddenMember() throws Exception {
        runTest("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/enumEntryInitializerWithOverriddenMember.kt");
    }

    @Test
    @TestMetadata("Int.kt")
    public void testInt() throws Exception {
        runTest("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/Int.kt");
    }

    @Test
    @TestMetadata("javaField.kt")
    public void testJavaField() throws Exception {
        runTest("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/javaField.kt");
    }

    @Test
    @TestMetadata("javaFieldClash.kt")
    public void testJavaFieldClash() throws Exception {
        runTest("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/javaFieldClash.kt");
    }

    @Test
    @TestMetadata("javaMethods.kt")
    public void testJavaMethods() throws Exception {
        runTest("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/javaMethods.kt");
    }

    @Test
    @TestMetadata("java.lang.String.kt")
    public void testJava_lang_String() throws Exception {
        runTest("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/java.lang.String.kt");
    }

    @Test
    @TestMetadata("kotlin.Function2.kt")
    public void testKotlin_Function2() throws Exception {
        runTest("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/kotlin.Function2.kt");
    }

    @Test
    @TestMetadata("MutableList.kt")
    public void testMutableList() throws Exception {
        runTest("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/MutableList.kt");
    }

    @Test
    @TestMetadata("substitutionOverride.kt")
    public void testSubstitutionOverride() throws Exception {
        runTest("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/substitutionOverride.kt");
    }

    @Nested
    @TestMetadata("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/withTestCompilerPluginEnabled")
    @TestDataPath("$PROJECT_ROOT")
    public class WithTestCompilerPluginEnabled {
        @Test
        public void testAllFilesPresentInWithTestCompilerPluginEnabled() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/withTestCompilerPluginEnabled"), Pattern.compile("^(.+)\\.kt$"), null, true);
        }

        @Test
        @TestMetadata("customSerlializable.kt")
        public void testCustomSerlializable() throws Exception {
            runTest("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/withTestCompilerPluginEnabled/customSerlializable.kt");
        }

        @Test
        @TestMetadata("generatedCompanionWithFoo.kt")
        public void testGeneratedCompanionWithFoo() throws Exception {
            runTest("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/withTestCompilerPluginEnabled/generatedCompanionWithFoo.kt");
        }

        @Test
        @TestMetadata("nestedClassAndMaterializeMember.kt")
        public void testNestedClassAndMaterializeMember() throws Exception {
            runTest("analysis/analysis-api/testData/components/scopeProvider/memberScopeByFqName/withTestCompilerPluginEnabled/nestedClassAndMaterializeMember.kt");
        }
    }
}
