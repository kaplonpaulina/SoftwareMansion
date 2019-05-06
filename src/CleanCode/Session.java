package CleanCode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Session {

    private int sessionLiveInMinutes;
    private int numberOfRequiredSessions;
    private DateTimeFormatter formatter;
    private int numberOfConsideredDays;


    public Session(){

        this.sessionLiveInMinutes = 30;
        this.numberOfRequiredSessions = 6;
        this.numberOfConsideredDays = 3;
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public Session(int sessionLiveInMinutes, int numberOfRequiredSessions, int numberOfConsideredDays, DateTimeFormatter formatter){
        this.sessionLiveInMinutes = sessionLiveInMinutes;
        this.numberOfRequiredSessions = numberOfRequiredSessions;
        this.numberOfConsideredDays = numberOfConsideredDays;
        this.formatter = formatter;
    }

    public List<LocalDateTime> stringLogToLocalDateTime(List<String> logDatesInStringFormat) {

        List<LocalDateTime> listOfLogTimes = new ArrayList<>();

        for (String dateString : logDatesInStringFormat
        ) {
            LocalDateTime date = LocalDateTime.parse(dateString, formatter);
            listOfLogTimes.add(date);
        }

        return listOfLogTimes;
    }

    public LocalDateTime getCurrDayDate(List<LocalDateTime> logDatesList) {

        int size = logDatesList.size();
        return size > 0 ? logDatesList.get(size - 1) : logDatesList.get(0);

    }


    public boolean loggedInLastNumberOfDays(List<LocalDateTime> logDatesList, LocalDateTime currDay) {

        LocalDateTime timeHolder = currDay;

        Set<Integer> loggedDaysOfYearSet = new HashSet<>();

        loggedDaysOfYearSet.add(currDay.getDayOfYear());

        for (int consideredDaysIter = 1; consideredDaysIter < numberOfConsideredDays; consideredDaysIter++) {

            timeHolder = timeHolder.minusDays(1);

            loggedDaysOfYearSet.add(timeHolder.getDayOfYear());
        }

        logDatesList.stream().forEach(logDate -> loggedDaysOfYearSet.remove(logDate.getDayOfYear()));

        if (loggedDaysOfYearSet.isEmpty()) {
            return true;
        }

        return false;
    }


    public int loggedSesionNum(List<LocalDateTime> logDatesList) {

        LocalDateTime timeHolder = logDatesList.get(0);

        int loggedSessionNumber = 1;

        for (LocalDateTime logDate : logDatesList
        ) {


            if (timeHolder.getDayOfYear() == logDate.getDayOfYear()) {

                if (timeHolder.getDayOfYear() == timeHolder.plusMinutes(sessionLiveInMinutes).getDayOfYear()) {

                    timeHolder = timeHolder.plusMinutes(sessionLiveInMinutes);

                    if (logDate.isAfter(timeHolder)) {
                        loggedSessionNumber++;
                        timeHolder = logDate;
                    }
                }
                continue;

            } else {
                loggedSessionNumber++;
                timeHolder = logDate;
            }


        }

        return loggedSessionNumber;
    }


    public boolean askOpinion(List<String> loggedDatesInStrinFormat) {

        List<LocalDateTime> loggedDates = stringLogToLocalDateTime(loggedDatesInStrinFormat);
        boolean loggedInLasDays = loggedInLastNumberOfDays(loggedDates, getCurrDayDate(loggedDates));

        return loggedInLasDays && loggedSesionNum(loggedDates) >= numberOfRequiredSessions;

    }


}
