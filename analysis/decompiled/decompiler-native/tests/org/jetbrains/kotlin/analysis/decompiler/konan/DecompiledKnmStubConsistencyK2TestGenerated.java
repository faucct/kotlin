/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.decompiler.konan;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder")
@TestDataPath("$PROJECT_ROOT")
public class DecompiledKnmStubConsistencyK2TestGenerated extends AbstractDecompiledKnmStubConsistencyK2Test {
    @Test
    public void testAllFilesPresentInClsFileStubBuilder() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder"), Pattern.compile("^([^\\.]+)$"), null, false);
    }

    @Test
    @TestMetadata("AnnotatedFlexibleTypes")
    public void testAnnotatedFlexibleTypes() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnnotatedFlexibleTypes/");
    }

    @Test
    @TestMetadata("AnnotatedParameterInEnumConstructor")
    public void testAnnotatedParameterInEnumConstructor() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnnotatedParameterInEnumConstructor/");
    }

    @Test
    @TestMetadata("AnnotatedParameterInInnerClassConstructor")
    public void testAnnotatedParameterInInnerClassConstructor() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnnotatedParameterInInnerClassConstructor/");
    }

    @Test
    @TestMetadata("AnnotationClass")
    public void testAnnotationClass() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnnotationClass/");
    }

    @Test
    @TestMetadata("AnnotationValues")
    public void testAnnotationValues() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnnotationValues/");
    }

    @Test
    @TestMetadata("Annotations")
    public void testAnnotations() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Annotations/");
    }

    @Test
    @TestMetadata("AnnotationsOnNullableTypes")
    public void testAnnotationsOnNullableTypes() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnnotationsOnNullableTypes/");
    }

    @Test
    @TestMetadata("AnnotationsOnParenthesizedTypes")
    public void testAnnotationsOnParenthesizedTypes() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnnotationsOnParenthesizedTypes/");
    }

    @Test
    @TestMetadata("AnonymousReturnWithGenericType")
    public void testAnonymousReturnWithGenericType() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/AnonymousReturnWithGenericType/");
    }

    @Test
    @TestMetadata("ClassMembers")
    public void testClassMembers() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/ClassMembers/");
    }

    @Test
    @TestMetadata("ClassObject")
    public void testClassObject() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/ClassObject/");
    }

    @Test
    @TestMetadata("Const")
    public void testConst() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Const/");
    }

    @Test
    @TestMetadata("ContextReceiversCallableMembers")
    public void testContextReceiversCallableMembers() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/ContextReceiversCallableMembers/");
    }

    @Test
    @TestMetadata("ContextReceiversOnClass")
    public void testContextReceiversOnClass() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/ContextReceiversOnClass/");
    }

    @Test
    @TestMetadata("ContextReceiversOnFunctionType")
    public void testContextReceiversOnFunctionType() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/ContextReceiversOnFunctionType/");
    }

    @Test
    @TestMetadata("ContextReceiversOnTopLevelCallables")
    public void testContextReceiversOnTopLevelCallables() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/ContextReceiversOnTopLevelCallables/");
    }

    @Test
    @TestMetadata("Contracts")
    public void testContracts() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Contracts/");
    }

    @Test
    @TestMetadata("DataClass")
    public void testDataClass() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/DataClass/");
    }

    @Test
    @TestMetadata("DefinitelyNotNullTypes")
    public void testDefinitelyNotNullTypes() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/DefinitelyNotNullTypes/");
    }

    @Test
    @TestMetadata("Delegation")
    public void testDelegation() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Delegation/");
    }

    @Test
    @TestMetadata("DependencyOnNestedClasses")
    public void testDependencyOnNestedClasses() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/DependencyOnNestedClasses/");
    }

    @Test
    @TestMetadata("Enum")
    public void testEnum() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Enum/");
    }

    @Test
    @TestMetadata("FlexibleTypes")
    public void testFlexibleTypes() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/FlexibleTypes/");
    }

    @Test
    @TestMetadata("FunInterfaceDeclaration")
    public void testFunInterfaceDeclaration() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/FunInterfaceDeclaration/");
    }

    @Test
    @TestMetadata("InheritingClasses")
    public void testInheritingClasses() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/InheritingClasses/");
    }

    @Test
    @TestMetadata("InnerClassEnumEntry")
    public void testInnerClassEnumEntry() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/InnerClassEnumEntry/");
    }

    @Test
    @TestMetadata("InnerTypes")
    public void testInnerTypes() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/InnerTypes/");
    }

    @Test
    @TestMetadata("LocalClass")
    public void testLocalClass() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/LocalClass/");
    }

    @Test
    @TestMetadata("Modifiers")
    public void testModifiers() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Modifiers/");
    }

    @Test
    @TestMetadata("MultifileClass")
    public void testMultifileClass() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/MultifileClass/");
    }

    @Test
    @TestMetadata("NamedCompanionObject")
    public void testNamedCompanionObject() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/NamedCompanionObject/");
    }

    @Test
    @TestMetadata("NestedClasses")
    public void testNestedClasses() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/NestedClasses/");
    }

    @Test
    @TestMetadata("Objects")
    public void testObjects() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Objects/");
    }

    @Test
    @TestMetadata("PrivateConstField")
    public void testPrivateConstField() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/PrivateConstField/");
    }

    @Test
    @TestMetadata("PrivateToThis")
    public void testPrivateToThis() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/PrivateToThis/");
    }

    @Test
    @TestMetadata("Sealed")
    public void testSealed() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Sealed/");
    }

    @Test
    @TestMetadata("SecondaryConstructors")
    public void testSecondaryConstructors() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/SecondaryConstructors/");
    }

    @Test
    @TestMetadata("SpecialNames")
    public void testSpecialNames() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/SpecialNames/");
    }

    @Test
    @TestMetadata("SuspendLambda")
    public void testSuspendLambda() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/SuspendLambda/");
    }

    @Test
    @TestMetadata("TopJvmPackageName")
    public void testTopJvmPackageName() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/TopJvmPackageName/");
    }

    @Test
    @TestMetadata("TopLevelMembersAnnotatedKt")
    public void testTopLevelMembersAnnotatedKt() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/TopLevelMembersAnnotatedKt/");
    }

    @Test
    @TestMetadata("TopLevelMembersKt")
    public void testTopLevelMembersKt() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/TopLevelMembersKt/");
    }

    @Test
    @TestMetadata("TypeAliases")
    public void testTypeAliases() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/TypeAliases/");
    }

    @Test
    @TestMetadata("TypeBoundsAndDelegationSpecifiers")
    public void testTypeBoundsAndDelegationSpecifiers() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/TypeBoundsAndDelegationSpecifiers/");
    }

    @Test
    @TestMetadata("TypeModifiers")
    public void testTypeModifiers() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/TypeModifiers/");
    }

    @Test
    @TestMetadata("TypeParams")
    public void testTypeParams() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/TypeParams/");
    }

    @Test
    @TestMetadata("Types")
    public void testTypes() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/Types/");
    }

    @Test
    @TestMetadata("UnderscoreParameterName")
    public void testUnderscoreParameterName() throws Exception {
        runTest("analysis/decompiled/decompiler-to-file-stubs/testData/clsFileStubBuilder/UnderscoreParameterName/");
    }
}
