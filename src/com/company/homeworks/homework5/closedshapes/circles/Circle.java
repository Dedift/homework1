package com.company.homeworks.homework5.closedshapes.circles;

import com.company.homeworks.homework5.closedshapes.Point;

public class Circle extends Ellipse implements Rounded {

    private double radius;

    public Circle(Point centerPoint, double radius) {
        super(radius, radius, centerPoint);
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return Pi * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Pi;
    }

    @Override
    public void printRadius() {
        System.out.println("Радиус круга = " + radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", centerPoint=" + centerPoint +
                '}';
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius > 0) {
            this.radius = radius;
        } else System.out.println("У круга не может быть радиус равнен нулю или меньше нуля!");
    }
}
