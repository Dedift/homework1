package com.company.homeworks.homework3;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число в римском формате: ");
        String romanNumbers = scanner.nextLine().toUpperCase();
        char[] charsRromanNumbers = romanNumbers.toCharArray();

        if (isEmpty(romanNumbers) || !isRomanNumbers(charsRromanNumbers)) {
            System.out.println("Вы не ввели число в римском формате.");
        } else if (getArabicNumber(charsRromanNumbers) == -1) {
            System.out.println("Вы ввели число меньше 1 или больше 3999.");
        } else {
            System.out.println(getArabicNumber(charsRromanNumbers));
        }
    }

    public static boolean isEmpty(String anyString) {
        return "".equals(anyString);
    }

    public static boolean isRomanNumbers(char[] charToProcess) {
        for (int i = 0; i < charToProcess.length; i++) {
            if ('I' != charToProcess[i] &&
                    'V' != charToProcess[i] &&
                    'X' != charToProcess[i] &&
                    'L' != charToProcess[i] &&
                    'C' != charToProcess[i] &&
                    'D' != charToProcess[i] &&
                    'M' != charToProcess[i]) {
                return false;
            }
        }
        return true;
    }

    public static int getArabicNumber(char[] charToProcess) {
        int arabicNumber = 0;
        int previous = 0;
        int i = 0;
        int current = 0;

        if (isRomanNumbers(charToProcess)) {
            while (i < charToProcess.length) {
                switch (charToProcess[i]) {
                    case ('I'):
                        current = 1;
                        break;
                    case ('V'):
                        current = 5;
                        break;
                    case ('X'):
                        current = 10;
                        break;
                    case ('L'):
                        current = 50;
                        break;
                    case ('C'):
                        current = 100;
                        break;
                    case ('D'):
                        current = 500;
                        break;
                    case ('M'):
                        current = 1000;
                        break;
                }
                if (current > previous) {
                    arabicNumber += current - (previous * 2);
                } else {
                    arabicNumber += current;
                }
                previous = current;
                i++;
            }
        } else {
            return -1;
        }

        if (arabicNumber > 0 && arabicNumber < 4000) {
            return arabicNumber;
        } else {
            return -1;
        }
    }
}
