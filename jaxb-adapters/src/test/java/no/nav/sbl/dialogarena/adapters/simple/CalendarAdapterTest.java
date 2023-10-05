package no.nav.sbl.dialogarena.adapters.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalendarAdapterTest {
    private final CalendarAdapter calendarAdapter = new CalendarAdapter();

    @Test
    public void unmarshalYearMonthDay() throws Exception {
        String dateString = "2017-12-19";
        Calendar calendar = calendarAdapter.unmarshal(dateString);

        Assertions.assertNotNull(calendar);
        assertEquals(2017, calendar.get(Calendar.YEAR));

        // fordi januar er 0 i Java Calendar...
        assertEquals(12, calendar.get(Calendar.MONTH) + 1);
        assertEquals(19, calendar.get(Calendar.DAY_OF_MONTH));

    }

    @Test
    public void marshalYearhMonthDay() throws Exception {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2017, 11, 19);

        String dateString = calendarAdapter.marshal(gregorianCalendar);
        assertEquals("2017-12-19", dateString);
    }
}