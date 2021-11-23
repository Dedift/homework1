package com.company.homeworks.homework10;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2020, 6, 25);
        System.out.println(DateTimeUtils.getDaysBetweenDates(now, date));

        System.out.println(DateTimeUtils.getSecondsBetweenDates(now, date));

        System.out.println(RegexUtils.isMailingAddress("Vasya_Petrov@mail.org"));

        String hexadecimalNumbers = "0x4C6 Xenon 0x12 0xAD421 3242 book 0x23B4";
        System.out.println(RegexUtils.getHexadecimalNumbers(hexadecimalNumbers));
    }
}
