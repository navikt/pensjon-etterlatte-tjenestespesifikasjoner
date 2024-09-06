import java.net.URI

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
java.sourceCompatibility = JavaVersion.VERSION_21

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = URI("https://maven.pkg.github.com/navikt/pensjon-etterlatte-tjenestespesifikasjoner")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}