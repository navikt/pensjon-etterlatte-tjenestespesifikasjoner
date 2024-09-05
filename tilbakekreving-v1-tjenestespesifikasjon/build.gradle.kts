plugins {
    id("tjenestespesifikasjoner")
    id("com.sun.xml.ws.jaxws-maven-plugin") version "4.0.3"
}

dependencies {
    api(libs.com.sun.xml.ws.jaxws.rt)
}

description = "tilbakekreving-v1-tjenestespesifikasjon"
