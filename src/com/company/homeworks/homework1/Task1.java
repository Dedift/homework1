package com.company.homeworks.homework1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        System.out.println("Введите целое число: ");
        for (int number = scanner.nextInt(); number != 0; number /= 10){
            sum += number % 10;
        }
        System.out.println("Суммма цифр введенного числа: " + sum);
    }
}