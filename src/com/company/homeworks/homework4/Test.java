package com.company.homeworks.homework4;

public class Test {

    public static void main(String[] args) {
        Point leftUP = new Point(5, 9);
        Point rightDown = new Point(8, 2);
        Rectangle rectangle = new Rectangle(leftUP, rightDown);
        System.out.println(rectangle.getSquare());
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.GetDiagonal());
    }
}
