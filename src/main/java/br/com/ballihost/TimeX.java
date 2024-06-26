package br.com.ballihost;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
public class TimeX {
    private final LocalDateTime time = LocalDateTime.now();

    public TimeX() {
    }

    public TimeTypeX getHours() {
        return new TimeTypeX(time.getHour());
    }

    public TimeTypeX getMinutes() {
        return new TimeTypeX(time.getMinute());
    }

    public TimeTypeX getSeconds() {
        return new TimeTypeX(time.getSecond());
    }

    public String getHourFormat() {
        return new TimeFormat(time.getHour(), time.getMinute(), time.getSecond()).getHour();
    }

    public String getDateFormat() {
        return new TimeFormat(time.getDayOfMonth(), time.getMonthValue(), time.getYear()).getDate();
    }

    public String getEndDate(int preTime) {
        LocalDateTime timeEnd;
        timeEnd = LocalDateTime.of(time.plusMonths(preTime).getYear(), time.plusMonths(preTime).getMonthValue(), time.plusMonths(preTime).getDayOfMonth(), time.getHour(), time.getMinute());
        return String.format("Hour=%s,Date=%s", this.getHourFormat(), new TimeFormat(timeEnd.getDayOfMonth(), timeEnd.getMonthValue(), timeEnd.getYear()).getDate());
    }

    public long getTime() {
        return getComparisonValue(time);
    }

    public long getComparison(int year, int month, int day, int hour, int minute) {
        LocalDateTime otherTime = LocalDateTime.of(year, month, day, hour, minute);
        return getComparisonValue(otherTime);
    }

    public long getComparison(String value) {
        int year = Integer.parseInt(value.split("/")[2]);
        int month = Integer.parseInt(value.split("/")[1].split("/")[0]);
        int day = Integer.parseInt(value.split("/")[0].split("=")[2]);
        int hour = Integer.parseInt(value.split(":")[0].split("=")[1]);
        int minute = Integer.parseInt(value.split(":")[1].split(":")[0]);
        LocalDateTime otherTime = LocalDateTime.of(year, month, day, hour, minute);
        return getComparisonValue(otherTime);
    }

    private long getComparisonValue(LocalDateTime dateTime) {
        LocalDateTime epoch = LocalDateTime.of(1970, 1, 1, 0, 0);
        return ChronoUnit.MINUTES.between(epoch, dateTime);
    }
}
