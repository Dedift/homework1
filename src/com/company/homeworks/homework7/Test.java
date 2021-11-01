package com.company.homeworks.homework7;

import java.io.File;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        try {
            FileEditorUtils.getNumberOfLetter(new File("resources" + File.separator +
                    "homework7" + File.separator + "Poem.txt"));
        } catch (MyCheckedException e) {
            e.printStackTrace();
        }

        try {
            FileEditorUtils.createFileWithRandomNumbers();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileEditorUtils.sortFileWithNumbers(new File ("resources" + File.separator +
                    "homework7" + File.separator + "FileWithRandomNumbers.txt"));
        } catch (MyCheckedException e) {
            e.printStackTrace();
        }
    }
}
