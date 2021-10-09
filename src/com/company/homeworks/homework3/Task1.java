package com.company.homeworks.homework3;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        isPalindrome(string);
    }

    public static String getReverseString(String anyString) {
        String reverseString = "";

        if (isEmpty(anyString)) {
            return "";
        } else {
            for (int i = anyString.length() - 1; i >= 0; i--) {
                reverseString += anyString.charAt(i);
            }
            return reverseString;
        }
    }

    public static boolean isEmpty(String anyString) {
        return "".equals(anyString);
    }

    public static void isPalindrome(String anyString) {
        String reverseString = getReverseString(anyString);

        if (isEmpty(anyString)) {
            System.out.println("Вы ничего не ввели.");
        } else if (anyString.equals(reverseString)) {
            System.out.println("Введенная строка является палиндромом.");
        } else {
            System.out.println("Введенная строка не является палиндромом.");
        }
    }
}
