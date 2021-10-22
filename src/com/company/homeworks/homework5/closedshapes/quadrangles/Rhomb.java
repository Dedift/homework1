package com.company.homeworks.homework5.closedshapes.quadrangles;

import com.company.homeworks.homework5.closedshapes.AbstractClosedShape;
import com.company.homeworks.homework5.closedshapes.Point;

public class Rhomb extends AbstractClosedShape {

    private Point leftPoint;
    private Point upPoint;
    private Point centerPoint;
    private Point rightPoint;
    private Point downPoint;
    private double sideLength;

    public Rhomb(Point leftPoint, Point upPoint) {
        if (upPoint.getX() > leftPoint.getX() && upPoint.getY() > leftPoint.getY()) {
            this.leftPoint = leftPoint;
            this.upPoint = upPoint;
            this.sideLength = leftPoint.distance(upPoint);
            this.centerPoint = new Point(upPoint.getX(), leftPoint.getY());
            this.rightPoint = new Point(leftPoint.distance(centerPoint) + centerPoint.getX(), leftPoint.getY());
            this.downPoint = new Point(upPoint.getX(), centerPoint.getY() - upPoint.distance(centerPoint));
        } else System.out.println("Вы задали точки, не подходящие для построения ромба!");
    }

    @Override
    public double getSquare() {
        return getVerticalDiagonal() * getHorizontalDiagonal() / 2;
    }

    @Override
    public double getPerimeter() {
        return leftPoint.distance(upPoint) * 4;
    }

    public double getHorizontalDiagonal() {
        return leftPoint.distance(rightPoint);
    }

    public double getVerticalDiagonal() {
        return upPoint.distance(downPoint);
    }

    @Override
    public String toString() {
        return "Rhomb{" +
                "leftPoint=" + leftPoint +
                ", upPoint=" + upPoint +
                ", centerPoint=" + centerPoint +
                ", rightPoint=" + rightPoint +
                ", downPoint=" + downPoint +
                ", sideLength=" + sideLength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rhomb rhomb = (Rhomb) o;

        return Double.compare(rhomb.sideLength, sideLength) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(sideLength);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public Point getCenterPoint() {
        return centerPoint;
    }

    public Point getDownPoint() {
        return downPoint;
    }

    public Point getRightPoint() {
        return rightPoint;
    }

    public Point getLeftPoint() {
        return leftPoint;
    }

    public void setLeftPoint(Point leftPoint) {
        if (leftPoint.getX() < upPoint.getX() && leftPoint.getY() < upPoint.getY()) {
            this.leftPoint = leftPoint;
        } else System.out.println("Левая точка не может распологаться правее или выше верхней!");
    }

    public Point getUpPoint() {
        return upPoint;
    }

    public void setUpPoint(Point upPoint) {
        if (upPoint.getX() > leftPoint.getX() && upPoint.getY() > leftPoint.getY()) {
            this.upPoint = upPoint;
        } else System.out.println("Верхняя точка не может распологаться левее или ниже левой!");
    }

    public double getSideLength() {
        return sideLength;
    }
}