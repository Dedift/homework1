package com.company.homeworks.homework1;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество дней для расчета: ");
        int days = scanner.nextInt();
        int precipitation;
        int maxPrecipitationForDay = 0;
        double sum = 0;
        double mean;
        for (int i = 0; i < days; i++) {
            System.out.println("Введите количество осадков за день: ");
            precipitation = scanner.nextInt();
            sum += precipitation;
            if (maxPrecipitationForDay < precipitation)
                maxPrecipitationForDay = precipitation;
        }
        mean = sum / days;
        System.out.println("Расчеты проведены за: " + days + " дней.");
        System.out.println("За этот период в сумме выпало " + sum + " мм осадков.");
        System.out.println("В среднем за день выпадало " + mean + " мм осадков.");
        System.out.println("Максимальное количество осадков за один день: " + maxPrecipitationForDay + " мм.");
    }
}