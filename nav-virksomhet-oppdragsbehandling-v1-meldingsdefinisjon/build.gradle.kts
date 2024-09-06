plugins {
    id("tjenestespesifikasjoner")
}

val jaxb: Configuration by configurations.creating

val jaxbVersion = "4.0.2"
val xjcOutputDir = "${layout.buildDirectory.get()}/generated/sources/xjc/main"


dependencies {
    api("org.glassfish.jaxb:jaxb-runtime:$jaxbVersion")
    jaxb("com.gitlab.virtual-machinist:any-annotate:2.1.0")
    jaxb("org.glassfish.jaxb:jaxb-xjc:$jaxbVersion")
    jaxb("jakarta.xml.bind:jakarta.xml.bind-api:$jaxbVersion")
    jaxb("org.glassfish.jaxb:jaxb-runtime:$jaxbVersion")
}

description = "nav-virksomhet-oppdragsbehandling-v1-meldingsdefinisjon"

/*
Implementasjon henta frå https://stackoverflow.com/a/66775613 og tweaka vidare på
 */
val xjc by tasks.registering(JavaExec::class) {
    mkdir(xjcOutputDir)
    classpath = jaxb
    mainClass.set("com.sun.tools.xjc.XJCFacade")
    args = listOf(
        "-d",
        xjcOutputDir,
        "-b",
        "src/main/xjb",
        "-encoding",
        "UTF-8",
        "-no-header",
        "-quiet",
        "-Xany-annotate",
        "-extension",
        "src/main/xsd"
    )
}

tasks.withType<JavaCompile>().configureEach {
    dependsOn(xjc)
}

sourceSets {
    main {
        java {
            srcDirs(
                files(xjcOutputDir) {
                    builtBy(xjc)
                }
            )
        }
    }
}