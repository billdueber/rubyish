import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


// Default sucked. From
// https://stackoverflow.com/questions/50128728/how-do-i-use-the-native-junit-5-support-in-gradle-with-the-kotlin-dsl

plugins {
    val kotlinVersion = "1.3.0"
    application
    kotlin("jvm") version kotlinVersion
    java // Required by at least JUnit.

}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    compile(kotlin("stdlib"))
    // To "prevent strange errors".
    compile(kotlin("reflect"))
    // Kotlin reflection.
    compile(kotlin("test"))
    compile(kotlin("test-junit"))

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.2.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.2.0")
    testRuntime("org.junit.platform:junit-platform-console:1.2.0")

    // Kotlintest
    testCompile("io.kotlintest:kotlintest-core:3.1.10")
    testCompile("io.kotlintest:kotlintest-assertions:3.1.10")
    testCompile("io.kotlintest:kotlintest-runner-junit5:3.1.10")

    testCompile("org.assertj:assertj-core:3.11.1")

    // Logging
    compile("org.slf4j:slf4j-api:1.7.25")
    testCompile("org.slf4j:slf4j-simple:1.7.25")
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform { }
}

//dependencies {
//    compile(kotlin("stdlib-jdk8"))
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.0")
//    testImplementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.0")
//
//    testImplementation ("org.spekframework.spek2:spek-dsl-jvm:2.0.0-alpha.1")  {
//        exclude("org.jetbrains.kotlin")
//    }
//    testRuntimeOnly ("org.spekframework.spek2:spek-runner-junit5:2.0.0-alpha.1") {
//        exclude("org.junit.platform")
//        exclude("org.jetbrains.kotlin")
//    }
//
//    // spek requires kotlin-reflect, can be omitted if already in the classpath
//    testRuntimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.3.0")
//    testCompile("org.assertj:assertj-core:3.11.1")
//
//}

tasks {
    // Use the built-in JUnit support of Gradle.
    "test"(Test::class) {
        useJUnitPlatform()
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}



