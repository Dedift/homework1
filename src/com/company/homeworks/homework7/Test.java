package com.company.homeworks.homework7;

import java.io.File;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        try {
            com.company.homeworks.homework7.FileEditorUtils.getNumberOfLetter(new File("resources" + File.separator +
                    "homework7" + File.separator + "Poem.txt"));
        } catch (com.company.homeworks.homework7.MyCheckedException e) {
            e.printStackTrace();
        }

        try {
            com.company.homeworks.homework7.FileEditorUtils.createFileWithRandomNumbers();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            com.company.homeworks.homework7.FileEditorUtils.sortFileWithNumbers(new File ("resources" + File.separator +
                    "homework7" + File.separator + "FileWithRandomNumbers.txt"));
        } catch (com.company.homeworks.homework7.MyCheckedException e) {
            e.printStackTrace();
        }
    }
}