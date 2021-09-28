package com.company.homeworks.homework1;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите до какого значения вычислять число Фибоначчи: ");
        int number = scanner.nextInt();
        int firstNumberFibonacci = 0;
        int secondNumberFibonacci = 1;
        int thirdNumberFibonacci;
        for (int i = 0; firstNumberFibonacci < number; i++){
            System.out.println(firstNumberFibonacci);
            thirdNumberFibonacci = firstNumberFibonacci + secondNumberFibonacci;
            firstNumberFibonacci = secondNumberFibonacci;
            secondNumberFibonacci = thirdNumberFibonacci;
        }
    }
}