package com.company.homeworks.homework8.Text;

import java.io.*;
import java.util.*;

public final class TextEditorUtils {

    private TextEditorUtils() {
        throw new UnsupportedOperationException();
    }

    public static ArrayList<String> readTextFromFile(File fileWithText) {
        if (fileWithText != null && fileWithText.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileWithText));
                 Scanner scanner = new Scanner(bufferedReader)) {
                ArrayList<String> textFromFile = new ArrayList<>();
                while (scanner.hasNext()) {
                    String word = scanner.next().replaceAll("\\W", "");
                    textFromFile.add(word);
                }
                return textFromFile;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void getCountOfIdenticalWords(File fileWithText) {
        if (fileWithText != null && fileWithText.isFile()) {
            ArrayList<String> textFromFile = new ArrayList<>(readTextFromFile(fileWithText));
            HashSet<String> uniqueWords = new HashSet<>(textFromFile);
            ArrayList<String> textWithUniqueWords = new ArrayList<>(uniqueWords);
            Collections.sort(textWithUniqueWords, String.CASE_INSENSITIVE_ORDER);
            for (String x : textWithUniqueWords) {
                int count = 0;
                for (String y : textFromFile) {
                    if (x.equals(y)) {
                        count++;
                    }
                }
                System.out.println(x + " - " + count);
            }
        }
    }

    public static List<String> markLength4(List<String> anyList) {
        if (anyList != null) {
            for (int i = 0; i < anyList.size(); i++) {
                if (anyList.get(i).length() == 4) {
                    anyList.add(i, "****");
                    i++;
                }
            }
        }
        return anyList;
    }
}
