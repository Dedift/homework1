package com.company.homeworks.homework6.Exception;

public final class ExceptionUtils {

    private ExceptionUtils() throws MyUnCheckedException {
        throw new MyUnCheckedException();
    }

    public static void getNullPointerException() {
        String string = null;
        string.charAt(2);
    }

    public static void getArrayIndexOutOfBoundsException() {
        try {
            int array[] = new int[3];
            System.out.println(array[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public static void getIllegalArgumentException() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }

    public static void getMyUnCheckedException() throws MyUnCheckedException {
        try {
            String string = null;
            string.charAt(2);
        } catch (NullPointerException e) {
            throw new MyUnCheckedException(e);
        }
    }

    public static void getRandomException() throws IllegalArgumentException, NullPointerException, ArrayIndexOutOfBoundsException {
        double number = Math.random();
        if (number < 0.3) {
            throw new IllegalArgumentException();
        } else if (number > 0.7) {
            throw new NullPointerException();
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void exceptionOrNotException() throws IllegalArgumentException {
        double number = Math.random();
        if (number < 0.5) {
            throw new IllegalArgumentException();
        }
    }
}

