import org.gradle.api.publish.internal.PublicationInternal
import plugins.KotlinBuildPublishingPlugin.Companion.ADHOC_COMPONENT_NAME

description = "Annotation Processor for Kotlin (for using with embeddable compiler)"

plugins {
    `java-library`
}

dependencies {
    embedded(project(":kotlin-annotation-processing")) { isTransitive = false }
}

publish()

// Special compat publication for Kapt/Gradle until we will have minimal
// supported IDEA/Kotlin plugin version 1.9.0
val publications: PublicationContainer = extensions.getByType<PublishingExtension>().publications
val gradleCompatPublication = publications.register<MavenPublication>("gradleCompat") {
    artifactId = "kotlin-annotation-processing-gradle"
    from(components[ADHOC_COMPONENT_NAME])

    // Workaround for https://github.com/gradle/gradle/issues/12324
    (this as PublicationInternal<*>).isAlias = true
}

runtimeJar(rewriteDefaultJarDepsToShadedCompiler())
sourcesJar()
javadocJar()
