package com.company.homeworks.homework5.closedshapes.triangles;

import com.company.homeworks.homework5.closedshapes.AbstractClosedShape;
import com.company.homeworks.homework5.closedshapes.Point;

public class IsoscelesTriangle extends AbstractClosedShape implements Triangulable {

    private Point leftPoint;
    private Point upPoint;
    private Point rightPoint;
    private Point bottomСenter;
    private double baseLength;
    private double lengthOfTheSides;

    public IsoscelesTriangle(Point leftPoint, Point upPoint) {
        if (upPoint.getX() > leftPoint.getX() && upPoint.getY() > leftPoint.getY()) {
            this.leftPoint = leftPoint;
            this.upPoint = upPoint;
            this.bottomСenter = new Point(upPoint.getX(), leftPoint.getY());
            this.rightPoint = new Point(bottomСenter.getX() + bottomСenter.distance(leftPoint), leftPoint.getY());
            this.baseLength = leftPoint.distance(rightPoint);
            this.lengthOfTheSides = leftPoint.distance(upPoint);
        } else System.out.println("Вы задали точки, не подходящие для построения равнобедренного треугольника!");
    }

    @Override
    public Point getCenterPoint() {
        return new Point(bottomСenter.getX(), bottomСenter.getY() + getBaseHeight() / 2);
    }

    @Override
    public double getInscribedCircleRadius() {
        return baseLength / 2 * Math.sqrt((2 * lengthOfTheSides - baseLength) / (2 * lengthOfTheSides + baseLength));
    }

    @Override
    public double getBaseHeight() {
        return upPoint.distance(bottomСenter);
    }

    @Override
    public double getPerimeter() {
        return leftPoint.distance(rightPoint) + leftPoint.distance(upPoint) * 2;
    }

    @Override
    public double getSquare() {
        return leftPoint.distance(rightPoint) * upPoint.distance(bottomСenter) / 2;
    }

    @Override
    public String toString() {
        return "IsoscelesTriangle{" +
                "leftPoint=" + leftPoint +
                ", upPoint=" + upPoint +
                ", rightPoint=" + rightPoint +
                ", bottomСenter=" + bottomСenter +
                ", baseLength=" + baseLength +
                ", lengthOfTheSides=" + lengthOfTheSides +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IsoscelesTriangle that = (IsoscelesTriangle) o;

        if (Double.compare(that.baseLength, baseLength) != 0) return false;
        return Double.compare(that.lengthOfTheSides, lengthOfTheSides) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(baseLength);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lengthOfTheSides);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Point getUpPoint() {
        return upPoint;
    }

    public void setUpPoint(Point upPoint) {
        if (upPoint.getX() > leftPoint.getX() && upPoint.getY() > leftPoint.getY()) {
            this.upPoint = upPoint;
        } else
            System.out.println("Верхняя точка равнобедренного треугольника не может распологаться левее или ниже левой точки!");
    }

    public Point getLeftPoint() {
        return leftPoint;
    }

    public void setLeftPoint(Point leftPoint) {
        if (leftPoint.getX() < upPoint.getX() && leftPoint.getY() < upPoint.getY()) {
            this.leftPoint = leftPoint;
        } else
            System.out.println("Левая точка равнобедренного треугольника не может распологаться правее или выше верхней точки!");
    }

    public Point getRightPoint() {
        return rightPoint;
    }

    public Point getBottomСenter() {
        return bottomСenter;
    }

    public double getBaseLength() {
        return baseLength;
    }

    public double getLengthOfTheSides() {
        return lengthOfTheSides;
    }
}
