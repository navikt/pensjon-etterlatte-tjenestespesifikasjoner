plugins {
    `java-library`
    `maven-publish`
}

repositories {
    gradlePluginPortal()
    mavenLocal()
    mavenCentral()
}

group = "no.nav.etterlatte.tjenestespesifikasjoner"
version = "0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_21

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}