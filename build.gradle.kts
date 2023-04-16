plugins {
    kotlin("jvm") version "1.8.0"
    antlr
    application
    java
}

group = "inno.ppa"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junitVersion = "5.9.2"
dependencies {
    antlr("org.antlr:antlr4:4.12.0")
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")

}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}

tasks {
    generateGrammarSource {
        outputDirectory = File("$buildDir/generated-src/antlr/main/inno/ppa/")
        copy {
            from("${buildDir}/generated-src/antlr/main/inno/ppa")
            into("src/main/kotlin/antlr-generated")
        }
    }
}
