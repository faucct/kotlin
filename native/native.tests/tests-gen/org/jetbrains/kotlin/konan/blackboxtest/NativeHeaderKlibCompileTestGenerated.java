/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.konan.blackboxtest;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateNativeTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("native/native.tests/testData/headerKlibs/compile")
@TestDataPath("$PROJECT_ROOT")
public class NativeHeaderKlibCompileTestGenerated extends AbstractNativeHeaderKlibCompileTest {
    @Test
    public void testAllFilesPresentInCompile() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("native/native.tests/testData/headerKlibs/compile"), Pattern.compile("^([^\\.]+)$"), null, false);
    }

    @Test
    @TestMetadata("anonymousObject")
    public void testAnonymousObject() throws Exception {
        runTest("native/native.tests/testData/headerKlibs/compile/anonymousObject/");
    }

    @Test
    @TestMetadata("classes")
    public void testClasses() throws Exception {
        runTest("native/native.tests/testData/headerKlibs/compile/classes/");
    }

    @Test
    @TestMetadata("clinit")
    public void testClinit() throws Exception {
        runTest("native/native.tests/testData/headerKlibs/compile/clinit/");
    }

    @Test
    @TestMetadata("inlineAnnotationInstantiation")
    public void testInlineAnnotationInstantiation() throws Exception {
        runTest("native/native.tests/testData/headerKlibs/compile/inlineAnnotationInstantiation/");
    }

    @Test
    @TestMetadata("inlineAnonymousObject")
    public void testInlineAnonymousObject() throws Exception {
        runTest("native/native.tests/testData/headerKlibs/compile/inlineAnonymousObject/");
    }

    @Test
    @TestMetadata("inlineCapture")
    public void testInlineCapture() throws Exception {
        runTest("native/native.tests/testData/headerKlibs/compile/inlineCapture/");
    }

    @Test
    @TestMetadata("inlineNoRegeneration")
    public void testInlineNoRegeneration() throws Exception {
        runTest("native/native.tests/testData/headerKlibs/compile/inlineNoRegeneration/");
    }

    @Test
    @TestMetadata("inlineReifiedFunction")
    public void testInlineReifiedFunction() throws Exception {
        runTest("native/native.tests/testData/headerKlibs/compile/inlineReifiedFunction/");
    }

    @Test
    @TestMetadata("inlineWhenMappings")
    public void testInlineWhenMappings() throws Exception {
        runTest("native/native.tests/testData/headerKlibs/compile/inlineWhenMappings/");
    }

    @Test
    @TestMetadata("innerObjectRegeneration")
    public void testInnerObjectRegeneration() throws Exception {
        runTest("native/native.tests/testData/headerKlibs/compile/innerObjectRegeneration/");
    }

    @Test
    @TestMetadata("kt-40133")
    public void testKt_40133() throws Exception {
        runTest("native/native.tests/testData/headerKlibs/compile/kt-40133/");
    }

    @Test
    @TestMetadata("privateOnlyConstructors")
    public void testPrivateOnlyConstructors() throws Exception {
        runTest("native/native.tests/testData/headerKlibs/compile/privateOnlyConstructors/");
    }

    @Test
    @TestMetadata("privateValueClassConstructor")
    public void testPrivateValueClassConstructor() throws Exception {
        runTest("native/native.tests/testData/headerKlibs/compile/privateValueClassConstructor/");
    }

    @Test
    @TestMetadata("topLevel")
    public void testTopLevel() throws Exception {
        runTest("native/native.tests/testData/headerKlibs/compile/topLevel/");
    }
}
