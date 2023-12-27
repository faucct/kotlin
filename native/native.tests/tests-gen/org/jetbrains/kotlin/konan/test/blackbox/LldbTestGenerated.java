/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.konan.test.blackbox;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.junit.jupiter.api.Tag;
import org.jetbrains.kotlin.konan.test.blackbox.support.group.UseStandardTestCaseGroupProvider;
import org.jetbrains.kotlin.konan.test.blackbox.support.EnforcedProperty;
import org.jetbrains.kotlin.konan.test.blackbox.support.ClassLevelProperty;
import org.jetbrains.kotlin.konan.test.blackbox.support.EnforcedHostTarget;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateNativeTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("native/native.tests/testData/lldb")
@TestDataPath("$PROJECT_ROOT")
@Tag("debugger")
@UseStandardTestCaseGroupProvider()
@EnforcedProperty(property = ClassLevelProperty.OPTIMIZATION_MODE, propertyValue = "DEBUG")
@EnforcedHostTarget()
public class LldbTestGenerated extends AbstractNativeBlackBoxTest {
    @Test
    public void testAllFilesPresentInLldb() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("native/native.tests/testData/lldb"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("canInspectArrayChildren.kt")
    public void testCanInspectArrayChildren() throws Exception {
        runTest("native/native.tests/testData/lldb/canInspectArrayChildren.kt");
    }

    @Test
    @TestMetadata("canInspectArrays.kt")
    public void testCanInspectArrays() throws Exception {
        runTest("native/native.tests/testData/lldb/canInspectArrays.kt");
    }

    @Test
    @TestMetadata("canInspectCatchParameter.kt")
    public void testCanInspectCatchParameter() throws Exception {
        runTest("native/native.tests/testData/lldb/canInspectCatchParameter.kt");
    }

    @Test
    @TestMetadata("canInspectClasses.kt")
    public void testCanInspectClasses() throws Exception {
        runTest("native/native.tests/testData/lldb/canInspectClasses.kt");
    }

    @Test
    @TestMetadata("canInspectStrings.kt")
    public void testCanInspectStrings() throws Exception {
        runTest("native/native.tests/testData/lldb/canInspectStrings.kt");
    }

    @Test
    @TestMetadata("canInspectValuesOfPrimitiveTypes.kt")
    public void testCanInspectValuesOfPrimitiveTypes() throws Exception {
        runTest("native/native.tests/testData/lldb/canInspectValuesOfPrimitiveTypes.kt");
    }

    @Test
    @TestMetadata("canStepThroughCode.kt")
    public void testCanStepThroughCode() throws Exception {
        runTest("native/native.tests/testData/lldb/canStepThroughCode.kt");
    }

    @Test
    @TestMetadata("dataClassCopyMethod.kt")
    public void testDataClassCopyMethod() throws Exception {
        runTest("native/native.tests/testData/lldb/dataClassCopyMethod.kt");
    }

    @Test
    @TestMetadata("kt33055.kt")
    public void testKt33055() throws Exception {
        runTest("native/native.tests/testData/lldb/kt33055.kt");
    }

    @Test
    @TestMetadata("kt33364.kt")
    public void testKt33364() throws Exception {
        runTest("native/native.tests/testData/lldb/kt33364.kt");
    }

    @Test
    @TestMetadata("kt42208.kt")
    public void testKt42208() throws Exception {
        runTest("native/native.tests/testData/lldb/kt42208.kt");
    }

    @Test
    @TestMetadata("kt42208WithPassingLambdaToAnotherFunction.kt")
    public void testKt42208WithPassingLambdaToAnotherFunction() throws Exception {
        runTest("native/native.tests/testData/lldb/kt42208WithPassingLambdaToAnotherFunction.kt");
    }

    @Test
    @TestMetadata("kt42208WithVariable.kt")
    public void testKt42208WithVariable() throws Exception {
        runTest("native/native.tests/testData/lldb/kt42208WithVariable.kt");
    }

    @Test
    @TestMetadata("kt47198.kt")
    public void testKt47198() throws Exception {
        runTest("native/native.tests/testData/lldb/kt47198.kt");
    }

    @Test
    @TestMetadata("kt47198WithBody.kt")
    public void testKt47198WithBody() throws Exception {
        runTest("native/native.tests/testData/lldb/kt47198WithBody.kt");
    }

    @Test
    @TestMetadata("kt61131.kt")
    public void testKt61131() throws Exception {
        runTest("native/native.tests/testData/lldb/kt61131.kt");
    }

    @Test
    @TestMetadata("stepThroughInlineArguments.kt")
    public void testStepThroughInlineArguments() throws Exception {
        runTest("native/native.tests/testData/lldb/stepThroughInlineArguments.kt");
    }
}
