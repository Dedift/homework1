package com.company.homeworks.homework2;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину массива: ");

        int size = scanner.nextInt();
        int array[] = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Введите элемент массива с индексом " + i + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Вы ввели массив: ");
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length - 1; j++) {
                if (array[i] == array[j + 1])
                    array[j + 1] -= array[i];
            }
        }
        System.out.print("После удаления одинаковых элементов получился массив: ");
        System.out.println(Arrays.toString(array));
    }
}
