package com.company.homeworks.homework2;

import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {

        int firstArray[] = {1, 4, 2, 4, 5, 9, 2};
        int secondArray[] = {5, 3, 7, 7, 8};
        int evenNumbers = 0;
        int oddNumbers = 1;
        int lastNumberSmallerArray;
        int i;
        int sumArrays[] = new int[firstArray.length + secondArray.length];

        for (i = 0; i < secondArray.length && i < firstArray.length; i++) {
            sumArrays[evenNumbers] = firstArray[i];
            sumArrays[oddNumbers] = secondArray[i];
            evenNumbers += 2;
            oddNumbers += 2;
        }

        lastNumberSmallerArray = i;

        for (int j = 0; lastNumberSmallerArray < firstArray.length ||
                lastNumberSmallerArray < secondArray.length; j++, evenNumbers++, lastNumberSmallerArray++) {
            if (firstArray.length > secondArray.length) {
                sumArrays[evenNumbers] = firstArray[lastNumberSmallerArray];
            } else {
                sumArrays[evenNumbers] = secondArray[lastNumberSmallerArray];
            }
        }
        System.out.println(Arrays.toString(sumArrays));
    }
}
