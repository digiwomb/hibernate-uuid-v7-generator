plugins {
    kotlin("jvm") version "2.1.10"
    `maven-publish`
}

group = "dev.digiwomb"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.fasterxml.uuid:java-uuid-generator:4.2.0")
    implementation("org.hibernate:hibernate-core:6.4.0.Final")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/digiwomb/hibernate-uuid-v7-generator")
            credentials {
                username = project.findProperty("github.username") as String?
                password = project.findProperty("github.token") as String?
            }
        }
    }
    publications {
        create<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}