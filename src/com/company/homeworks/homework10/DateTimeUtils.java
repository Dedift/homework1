package com.company.homeworks.homework10;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public final class DateTimeUtils {

    private DateTimeUtils() {
        throw new UnsupportedOperationException();
    }

    public static int getDaysBetweenDates(ChronoLocalDate first, ChronoLocalDate second) {
        if (Objects.nonNull(first) && Objects.nonNull(second)) {
            return (int) Math.abs(ChronoUnit.DAYS.between(first, second));
        }
        return -1;
    }

    public static int getSecondsBetweenDates(LocalDate first, LocalDate second) {
        if (Objects.nonNull(first) && Objects.nonNull(second)) {
            return (int) Math.abs(ChronoUnit.SECONDS.between(first.atTime(0, 0, 0),
                    second.atTime(0, 0, 0)));
        }
        return -1;
    }
}
