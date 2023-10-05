package no.nav.sbl.dialogarena.adapters;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;

public class DateTimeAdapter extends XmlAdapter<String, DateTime> {

    @Override
    public DateTime unmarshal(String value) {
    	return new DateTime(value);
    }

    @Override
    public String marshal(DateTime value) {
        return value.toString();
    }

}
