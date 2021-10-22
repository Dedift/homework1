package com.company.homeworks.homework5.closedshapes.quadrangles;

import com.company.homeworks.homework5.closedshapes.Point;

public class Foursquare extends Rectangle {

    public Foursquare(Point leftDownPoint, double height) {
        super(leftDownPoint, height, height);
    }

    public double getInscribedCircleRadius() {
        return height / 2;
    }

    public double getRadiusOfTheCircumscribedCircle() {
        return height * Math.sqrt(2) / 2;
    }

    @Override
    public String toString() {
        return "Foursquare{" +
                "leftUpPoint=" + leftUpPoint +
                ", rightUpPoint=" + rightUpPoint +
                ", rightDownPoint=" + rightDownPoint +
                ", leftDownPoint=" + leftDownPoint +
                ", height=" + height +
                '}';
    }

    @Override
    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
            this.width = height;
            this.leftUpPoint = new Point(leftDownPoint.getX(), leftDownPoint.getY() + height);
            this.rightUpPoint = new Point(leftUpPoint.getX() + width, leftUpPoint.getY());
            this.rightDownPoint = new Point(rightUpPoint.getX(), leftDownPoint.getY());
        } else System.out.println("У квадрата не может быть нулевая или отрицательная высота!");
    }

    @Override
    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
            this.height = width;
            this.leftUpPoint = new Point(leftDownPoint.getX(), leftDownPoint.getY() + height);
            this.rightUpPoint = new Point(leftUpPoint.getX() + width, leftUpPoint.getY());
            this.rightDownPoint = new Point(rightUpPoint.getX(), leftDownPoint.getY());
        } else System.out.println("У квадрата не может быть нулевая или отрицательная ширина!");
    }
}
