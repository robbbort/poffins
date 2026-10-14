plugins {
    id("java")
    id("dev.architectury.loom") version ("1.11-SNAPSHOT")
    kotlin("jvm") version ("2.2.20")
}

group = "robbbort"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://artefacts.cobblemon.com/releases/")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    minecraft("net.minecraft:minecraft:1.21.1")
    mappings(loom.officialMojangMappings())

    modImplementation("net.fabricmc:fabric-loader:0.19.5")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.116.17+1.21.1")

    modImplementation("net.fabricmc:fabric-language-kotlin:1.13.6+kotlin.2.2.20")

    modImplementation("com.cobblemon:fabric:1.8.2+1.21.1") {
        isTransitive = false
    }

    modRuntimeOnly("org.graalvm.js:js:22.3.0")
    modRuntimeOnly("org.graalvm.sdk:graal-sdk:22.3.0")
    modRuntimeOnly("org.graalvm.regex:regex:22.3.0")
    modRuntimeOnly("org.graalvm.truffle:truffle-api:22.3.0")
    modRuntimeOnly("com.ibm.icu:icu4j:71.1")
}

tasks {
    test {
        useJUnitPlatform()
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    compileJava {
        options.release.set(21)
    }
}