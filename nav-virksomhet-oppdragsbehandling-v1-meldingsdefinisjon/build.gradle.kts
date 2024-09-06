plugins {
    id("tjenestespesifikasjoner")
    id("com.github.bjornvester.xjc") version "1.8.1"
}

dependencies {
    api(libs.org.glassfish.jaxb.jaxb.runtime)
    implementation(libs.any.annotate)
}

description = "nav-virksomhet-oppdragsbehandling-v1-meldingsdefinisjon"


xjc {
    xsdDir.set(file("src/main/"))
    xjcVersion.set("3.0.2")
    addCompilationDependencies.set(true)
    options.set(listOf(
        "xjcClasspath 'com.gitlab.virtual-machinist:any-annotate:2.1.0"
    ))
}