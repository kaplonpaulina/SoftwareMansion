package CleanCode;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SessionTest {


    Session session;

    List<LocalDateTime> session6LastDays3;
    List<LocalDateTime> session5LastDays3;
    List<LocalDateTime> lastDays2;

    List<String> session6LastDays3Str;
    List<String> session5LastDays3Str;
    List<String> lastDays2Str;

    @Before
    public void setUp() throws Exception {

        session = new Session();

        session6LastDays3Str = new ArrayList<>(Arrays.asList("2017-03-10 08:13:11", "2017-03-10 19:01:27", "2017-03-11 07:35:55", "2017-03-11 16:15:11", "2017-03-12 08:01:41", "2017-03-12 17:19:08"));
        session5LastDays3Str = new ArrayList<>(Arrays.asList("2017-03-10 18:58:11", "2017-03-10 19:01:27", "2017-03-11 07:35:55", "2017-03-11 16:15:11", "2017-03-12 08:01:41", "2017-03-12 17:19:08"));
        lastDays2Str = new ArrayList<>(Arrays.asList("2017-03-08 17:11:13", "2017-03-11 17:22:47", "2017-03-11 19:23:51", "2017-03-11 22:03:12", "2017-03-12 08:32:04", "2017-03-12 13:19:08", "2017-03-12 17:19:08"));

        session6LastDays3 = session.stringLogToLocalDateTime(session6LastDays3Str);
        session5LastDays3 = session.stringLogToLocalDateTime(session5LastDays3Str);
        lastDays2 = session.stringLogToLocalDateTime(lastDays2Str);

    }

    @Test
    public void session6LastDays3GetCurrDayDate() {

        LocalDateTime result = LocalDateTime.parse("2017-03-12 17:19:08", session.getFormatter());
        assertEquals(result, session.getCurrDayDate(session6LastDays3));

    }

    @Test
    public void session5LastDays3GetCurrDayDate() {

        LocalDateTime result = LocalDateTime.parse("2017-03-12 17:19:08", session.getFormatter());
        assertEquals(result, session.getCurrDayDate(session5LastDays3));

    }

    @Test
    public void lastDays2GetCurrDayDate() {

        LocalDateTime result = LocalDateTime.parse("2017-03-12 17:19:08", session.getFormatter());
        assertEquals(result, session.getCurrDayDate(lastDays2));

    }

    @Test
    public void session6LastDays3LoggedInLastNumberOfDays() {
        boolean result = true;
        assertEquals(result, session.loggedInLastNumberOfDays(session6LastDays3, session.getCurrDayDate(session6LastDays3)));
    }

    @Test
    public void session5LastDays3LoggedInLastNumberOfDays() {
        boolean result = true;
        assertEquals(result, session.loggedInLastNumberOfDays(session5LastDays3, session.getCurrDayDate(session5LastDays3)));
    }

    @Test
    public void lastDays2LoggedInLastNumberOfDays() {
        boolean result = false;
        assertEquals(result, session.loggedInLastNumberOfDays(lastDays2, session.getCurrDayDate(lastDays2)));
    }

    @Test
    public void session6LastDays3LoggedSesionNum() {

        int result = 6;
        assertEquals(result, session.loggedSesionNum(session6LastDays3));

    }

    @Test
    public void session5LastDays3LoggedSesionNum() {

        int result = 5;
        assertEquals(result, session.loggedSesionNum(session5LastDays3));

    }

    @Test
    public void lastDays2LoggedSesionNum() {

        int result = 7;
        assertEquals(result, session.loggedSesionNum(lastDays2));

    }

    @Test
    public void session6LastDays3AskOpinion() {
        boolean result = true;
        assertEquals(result, session.askOpinion(session6LastDays3Str));
    }

    @Test
    public void session5LastDays3AskOpinion() {
        boolean result = false;
        assertEquals(result, session.askOpinion(session5LastDays3Str));
    }

    @Test
    public void lastDays2AskOpinion() {
        boolean result = false;
        assertEquals(result, session.askOpinion(lastDays2Str));
    }
}