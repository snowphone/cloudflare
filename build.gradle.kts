/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.7.1/userguide/building_java_projects.html
 */
group = "kr.sixtyfive"
version = "1.0"

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.5.0"
    id("org.beryx.runtime") version "1.12.5"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    mavenCentral()
    maven { url="https://jitpack.io".let(::uri) }
}

dependencies {
    implementation("com.github.snowphone:cjk-table:0.3")
    implementation("com.google.code.gson:gson:2.8.7")

    implementation(platform("org.http4k:http4k-bom:4.9.5.0"))
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-server-netty")
    implementation("org.http4k:http4k-client-apache")

    implementation("com.github.ajalt.clikt:clikt:3.0.1")

    implementation("io.github.microutils:kotlin-logging:2.0.4")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:29.0-jre")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

val executableName = "cloudflare"

application {
    // Define the main class for the application.
    mainClass.set("$group.CliKt")
    applicationName = executableName
    applicationDefaultJvmArgs = listOf("-Dfile.encoding=UTF-8", "-Dname=${rootProject.name}")
}

runtime {
    options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))
    jpackage {
        imageName = executableName
        imageOptions = listOf(
            "--win-console",
            "--icon", "src/main/resources/cloudflare.ico",
        )
    }
}
