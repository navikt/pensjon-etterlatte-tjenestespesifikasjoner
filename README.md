# Tjenestespesifikasjoner

Dette repoet  inneholder tjenestespesifikasjoner for de tjenestene som NAV tilbyr internt, og som vi bruker i Team Etterlatte.
Utgangspunktet for dette repoet er ein kopi av det vi brukte fra [Tjenestespesifikasjoner-repoet](https://github.com/navikt/tjenestespesifikasjoner).

De er maskinlesbare i form av WSDL/XSD/JSON-filer, og disse brukes som utgangspunkt for å
generere Javakode. Denne autogenererte koden blir kompilert og siden publisert, slik at konsumenter
kan bruke dem til å kommunisere med tjenestene.

### Gradle
```

dependencies {
    implementation 'no.nav.etterlatte.tjenestespesifikasjoner:navn-på-modul:Tag'
}
```

### Maven
```	
	<dependency>
	    <groupId>no.nav.etterlatte.tjenestespesifikasjoner</groupId>
	    <artifactId>navn-på-modul</artifactId>
	    <version>Tag</version>
	</dependency>
```


## Bygging
Koden bruker Jakarta-navnerommet, og forutsetter Java nyere enn 8.

`mvn install`

## Gjøre endringer, release

For å endre spesifikasjoner, lag en branch. Kjør bygget lokalt, da vil du
få siste endringer med `1-SNAPSHOT` som versjon. Test med en konsument at
endringene fungerer (sett versjon av tjenestespesifikasjoner til `0-SNAPSHOT` i konsumenten.)
Når testingen er ferdig, send en pull request til dette repoet.

Hver branch og pull request vil gå gjennom et CI-bygg.
Etter at en pull request er merget til main-branchen, vil
CI automatisk gjøre en release av hele repoet til Maven Central.
Alle modulene i dette repoet får samme versjonsnummer.
Versjonsnummeret til releasen blir `1.YYYY.MM.DD-HH-MM-commithash`.