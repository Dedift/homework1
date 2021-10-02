package com.company.homeworks.homework2;

public class Task4 {

    public static void main(String[] args) {
        int twoDimensionalArray[][] = {{1, 3, 5, 2, 4}, {9, 3, 4, 6, 7, 3}};
        int oneDimensionalArray[] = getOneDimensionalArray(twoDimensionalArray);

        for (int i = 0; i < oneDimensionalArray.length; i++)
            System.out.print(oneDimensionalArray[i] + " ");
    }

    public static int[] getOneDimensionalArray(int arrayToProcess[][]) {
        int oneDimensionalArrayLength = 0;
        int oneDimensionalArrayIndex = 0;

        for (int i = 0; i < arrayToProcess.length; i++) {
            oneDimensionalArrayLength += arrayToProcess[i].length;
        }

        int oneDimensionalArray[] = new int[oneDimensionalArrayLength];

        for (int i = 0; i < arrayToProcess.length; i++) {
            for (int j = 0; j < arrayToProcess[i].length; j++) {
                oneDimensionalArray[oneDimensionalArrayIndex++] = arrayToProcess[i][j];
            }
        }
        return oneDimensionalArray;
    }
}
