import java.net.URI

plugins {
    kotlin("jvm") version "1.3.61"
}

group = "dev.siro256.spigotpl.toscc"
version = "1.0.0"

repositories {
    mavenCentral()
    maven { url = URI("https://hub.spigotmc.org/nexus/content/repositories/snapshots") }
    maven { url = URI("https://oss.sonatype.org/content/repositories/snapshots") }
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compileOnly("org.spigotmc:spigot-api:1.12.2-R0.1-SNAPSHOT")
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "1.8"
    }

    withType<Jar> {
        from(configurations.getByName("compile").map { if (it.isDirectory) it else zipTree(it) })
    }
}