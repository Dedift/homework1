package com.company.homeworks.homework5.closedshapes.quadrangles;

import com.company.homeworks.homework5.closedshapes.AbstractClosedShape;
import com.company.homeworks.homework5.closedshapes.Point;

public class Rectangle extends AbstractClosedShape {

    protected Point leftUpPoint;
    protected Point rightUpPoint;
    protected Point rightDownPoint;
    protected Point leftDownPoint;
    protected double height;
    protected double width;

    public Rectangle(Point leftDownPoint, double height, double width) {
        if (height > 0 && width > 0) {
            this.height = height;
            this.width = width;
            this.leftDownPoint = leftDownPoint;
            this.leftUpPoint = new Point(leftDownPoint.getX(), leftDownPoint.getY() + height);
            this.rightUpPoint = new Point(leftUpPoint.getX() + width, leftUpPoint.getY());
            this.rightDownPoint = new Point(rightUpPoint.getX(), leftDownPoint.getY());
        } else System.out.println("У прямоугольника не может быть нулевая или отрицательная ширина/высота!");
    }

    @Override
    public Point getCenterPoint() {
        return new Point(leftDownPoint.getX() + width / 2, leftDownPoint.getY() + height / 2);
    }

    @Override
    public double getSquare() {
        return height * width;
    }

    @Override
    public double getPerimeter() {
        return (height + width) * 2;
    }

    public double getDiagonal() {
        return leftDownPoint.distance(rightUpPoint);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "leftUpPoint=" + leftUpPoint +
                ", rightUpPoint=" + rightUpPoint +
                ", rightDownPoint=" + rightDownPoint +
                ", leftDownPoint=" + leftDownPoint +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (Double.compare(rectangle.height, height) != 0) return false;
        return Double.compare(rectangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(height);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Point getLeftDownPoint() {
        return leftDownPoint;
    }

    public void setLeftDownPoint(Point leftDownPoint) {
        this.leftDownPoint = leftDownPoint;
        this.leftUpPoint = new Point(leftDownPoint.getX(), leftDownPoint.getY() + height);
        this.rightUpPoint = new Point(leftUpPoint.getX() + width, leftUpPoint.getY());
        this.rightDownPoint = new Point(rightUpPoint.getX(), leftDownPoint.getY());
    }

    public Point getLeftUpPoint() {
        return leftUpPoint;
    }

    public Point getRightUpPoint() {
        return rightUpPoint;
    }

    public Point getRightDownPoint() {
        return rightDownPoint;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
            this.leftUpPoint = new Point(leftDownPoint.getX(), leftDownPoint.getY() + height);
            this.rightUpPoint = new Point(leftUpPoint.getX() + width, leftUpPoint.getY());
            this.rightDownPoint = new Point(rightUpPoint.getX(), leftDownPoint.getY());
        } else System.out.println("У прямоугольника не может быть нулевая или отрицательная высота!");
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
            this.leftUpPoint = new Point(leftDownPoint.getX(), leftDownPoint.getY() + height);
            this.rightUpPoint = new Point(leftUpPoint.getX() + width, leftUpPoint.getY());
            this.rightDownPoint = new Point(rightUpPoint.getX(), leftDownPoint.getY());
        } else System.out.println("У прямоугольника не может быть нулевая или отрицательная ширина!");
    }
}