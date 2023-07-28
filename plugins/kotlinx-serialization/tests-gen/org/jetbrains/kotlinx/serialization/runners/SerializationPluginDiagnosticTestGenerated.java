/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlinx.serialization.runners;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlinx.serialization.TestGeneratorKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("plugins/kotlinx-serialization/testData/diagnostics")
@TestDataPath("$PROJECT_ROOT")
public class SerializationPluginDiagnosticTestGenerated extends AbstractSerializationPluginDiagnosticTest {
    @Test
    @TestMetadata("abstractCustomSerializer.kt")
    public void testAbstractCustomSerializer() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/abstractCustomSerializer.kt");
    }

    @Test
    public void testAllFilesPresentInDiagnostics() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("plugins/kotlinx-serialization/testData/diagnostics"), Pattern.compile("^(.+)\\.kt$"), Pattern.compile("^(.+)\\.fir\\.kts?$"), true);
    }

    @Test
    @TestMetadata("companionObjectSerializers.kt")
    public void testCompanionObjectSerializers() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/companionObjectSerializers.kt");
    }

    @Test
    @TestMetadata("customSerializers.kt")
    public void testCustomSerializers() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/customSerializers.kt");
    }

    @Test
    @TestMetadata("DuplicateSerialName.kt")
    public void testDuplicateSerialName() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/DuplicateSerialName.kt");
    }

    @Test
    @TestMetadata("EnumDuplicateSerialName.kt")
    public void testEnumDuplicateSerialName() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/EnumDuplicateSerialName.kt");
    }

    @Test
    @TestMetadata("externalSerialierJava.kt")
    public void testExternalSerialierJava() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/externalSerialierJava.kt");
    }

    @Test
    @TestMetadata("ExternalSerializers.kt")
    public void testExternalSerializers() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/ExternalSerializers.kt");
    }

    @Test
    @TestMetadata("GenericArrays.kt")
    public void testGenericArrays() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/GenericArrays.kt");
    }

    @Test
    @TestMetadata("IncorrectTransient.kt")
    public void testIncorrectTransient() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/IncorrectTransient.kt");
    }

    @Test
    @TestMetadata("IncorrectTransient2.kt")
    public void testIncorrectTransient2() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/IncorrectTransient2.kt");
    }

    @Test
    @TestMetadata("InheritableInfo.kt")
    public void testInheritableInfo() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/InheritableInfo.kt");
    }

    @Test
    @TestMetadata("LazyRecursionBug.kt")
    public void testLazyRecursionBug() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/LazyRecursionBug.kt");
    }

    @Test
    @TestMetadata("LocalAndAnonymous.kt")
    public void testLocalAndAnonymous() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/LocalAndAnonymous.kt");
    }

    @Test
    @TestMetadata("metaSerializableNested.kt")
    public void testMetaSerializableNested() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/metaSerializableNested.kt");
    }

    @Test
    @TestMetadata("NoSuitableCtorInParent.kt")
    public void testNoSuitableCtorInParent() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/NoSuitableCtorInParent.kt");
    }

    @Test
    @TestMetadata("NonSerializable.kt")
    public void testNonSerializable() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/NonSerializable.kt");
    }

    @Test
    @TestMetadata("NullabilityIncompatible.kt")
    public void testNullabilityIncompatible() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/NullabilityIncompatible.kt");
    }

    @Test
    @TestMetadata("ParamIsNotProperty.kt")
    public void testParamIsNotProperty() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/ParamIsNotProperty.kt");
    }

    @Test
    @TestMetadata("repeatableSerialInfo.kt")
    public void testRepeatableSerialInfo() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/repeatableSerialInfo.kt");
    }

    @Test
    @TestMetadata("SerializableEnums.kt")
    public void testSerializableEnums() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/SerializableEnums.kt");
    }

    @Test
    @TestMetadata("SerializableIgnored.kt")
    public void testSerializableIgnored() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/SerializableIgnored.kt");
    }

    @Test
    @TestMetadata("serializerFromOtherModule.kt")
    public void testSerializerFromOtherModule() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/serializerFromOtherModule.kt");
    }

    @Test
    @TestMetadata("SerializerTypeCompatibleForSpecials.kt")
    public void testSerializerTypeCompatibleForSpecials() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/SerializerTypeCompatibleForSpecials.kt");
    }

    @Test
    @TestMetadata("SerializerTypeIncompatible.kt")
    public void testSerializerTypeIncompatible() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/SerializerTypeIncompatible.kt");
    }

    @Test
    @TestMetadata("SerializerTypeIncompatibleViaTypealias.kt")
    public void testSerializerTypeIncompatibleViaTypealias() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/SerializerTypeIncompatibleViaTypealias.kt");
    }

    @Test
    @TestMetadata("Transients.kt")
    public void testTransients() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/Transients.kt");
    }

    @Test
    @TestMetadata("typeAliases.kt")
    public void testTypeAliases() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/typeAliases.kt");
    }

    @Test
    @TestMetadata("typeAliasesCustomized.kt")
    public void testTypeAliasesCustomized() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/diagnostics/typeAliasesCustomized.kt");
    }
}
