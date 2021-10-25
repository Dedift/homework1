package com.company.homeworks.homework6;

import com.company.homeworks.homework6.Exception.ExceptionUtils;
import com.company.homeworks.homework6.Exception.MyUnCheckedException;

public class Test {

    public static void main(String[] args) {
        try {
            ExceptionUtils.getNullPointerException();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        ExceptionUtils.getArrayIndexOutOfBoundsException();

        try {
            ExceptionUtils.getIllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            ExceptionUtils.getMyUnCheckedException();
        } catch (MyUnCheckedException e) {
            System.out.println(e.getCause());
        }

        try {
            ExceptionUtils.getRandomException();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        try {
            ExceptionUtils.exceptionOrNotException();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Исключения обработаны");
        }
    }
}
