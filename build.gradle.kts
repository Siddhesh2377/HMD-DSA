plugins {
    kotlin("jvm") version "2.1.21"
    application  // Missing in your version
}

group = "com.dark.nurov.cli"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("MainKt")
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}
