plugins {
    id("tjenestespesifikasjoner")
    id("com.github.bjornvester.wsdl2java") version "2.0.2"
}
dependencies {
    api(libs.com.sun.xml.ws.jaxws.rt)
}

description = "avstemming-v1-tjenestespesifikasjon"

wsdl2java {
    wsdlDir.set(file("src/main/wsdl"))
    useJakarta = true
}
