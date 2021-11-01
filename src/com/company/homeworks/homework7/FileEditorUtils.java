package com.company.homeworks.homework7;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public final class FileEditorUtils {

    private FileEditorUtils() {
        throw new UnsupportedOperationException();
    }

    public static void getNumberOfLetter(File anyFile) throws MyCheckedException {
        if (anyFile != null && anyFile.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(anyFile));
                 BufferedWriter bufferedWriter = new BufferedWriter(
                         new FileWriter("resources" + File.separator + "homework7" + File.separator +
                                 "NumberOfLetters" + anyFile.getName(), true))) {
                char[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
                        'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т',
                        'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
                char[] allFileChars = new char[(int) anyFile.length()];
                int indexAllFileChars = 0;
                String line = bufferedReader.readLine().toLowerCase();
                while (line != null) {
                    char[] lineChars = line.toCharArray();
                    line = bufferedReader.readLine();
                    for (int i = 0; i < lineChars.length; i++, indexAllFileChars++) {
                        allFileChars[indexAllFileChars] = lineChars[i];
                    }
                }
                for (char alphabetLetter : alphabet) {
                    int numberOfLetters = 0;
                    for (char fileLetter : allFileChars) {
                        if (alphabetLetter == fileLetter) {
                            numberOfLetters += 1;
                        }
                    }
                    bufferedWriter.write(alphabetLetter + " - " + numberOfLetters + "\n");
                }
            } catch (FileNotFoundException e) {
                throw new MyCheckedException();
            } catch (IOException e) {
                throw new MyCheckedException();
            }
        }
    }

    public static void createFileWithRandomNumbers() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resources" + File.separator +
                "homework7" + File.separator + "FileWithRandomNumbers.txt", true))) {
            for (int i = 0; i < 50; i++) {
                bufferedWriter.write((int) (Math.random() * 100) + " ");
            }
        }
    }

    public static void sortFileWithNumbers(File fileWithNumbers) throws MyCheckedException {
        if (fileWithNumbers != null && fileWithNumbers.isFile() && isFileWithNumbers(fileWithNumbers)) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileWithNumbers));
                 Scanner scanner = new Scanner(bufferedReader);
                 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resources" + File.separator +
                         "homework7" + File.separator + "FileWithSortNumbers.txt"))) {
                int[] numbersFromFile = new int[getNumberOfDigits(fileWithNumbers)];
                for (int i = 0; i < numbersFromFile.length; i++) {
                    if (scanner.hasNext()) {
                        int x = scanner.nextInt();
                        numbersFromFile[i] = x;
                    }
                }
                getSortArray(numbersFromFile);
                bufferedWriter.write(Arrays.toString(numbersFromFile));
            } catch (FileNotFoundException fileNotFoundException) {
                throw new MyCheckedException();
            } catch (IOException ioException) {
                throw new MyCheckedException();
            }
        }
    }

    public static int getNumberOfDigits(File fileWithNumbers) {
        if (fileWithNumbers != null && fileWithNumbers.isFile() && isFileWithNumbers(fileWithNumbers)) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileWithNumbers));
                 Scanner scannerArrayLength = new Scanner(bufferedReader)) {
                int arrayLength = 0;
                while (scannerArrayLength.hasNext()) {
                    arrayLength += 1;
                    scannerArrayLength.nextInt();
                }
                return arrayLength;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public static int[] getSortArray(int[] intArray) {
        int j;
        for (int i = 1; i < intArray.length; i++) {
            int current = intArray[i];
            for (j = i - 1; j >= 0 && current < intArray[j]; j--) {
                intArray[j + 1] = intArray[j];
            }
            intArray[j + 1] = current;
        }
        return intArray;
    }

    public static boolean isFileWithNumbers(File fileWithNumbers) {
        if (fileWithNumbers != null && fileWithNumbers.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileWithNumbers));
                 Scanner scanner = new Scanner(bufferedReader)) {
                while (scanner.hasNext()) {
                    Integer.parseInt(scanner.next());
                }
            } catch (NumberFormatException e) {
                return false;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
