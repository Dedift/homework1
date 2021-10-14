package com.company.homeworks.homework4;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point anyPoint) {
        return Math.sqrt((anyPoint.x - this.x) * (anyPoint.x - this.x) + (anyPoint.y - this.y) * (anyPoint.y - this.y));
    }

    public double getX() {
        return x;
    }

    public double setX(double x) {
        return this.x = x;
    }

    public double getY() {
        return y;
    }

    public double setY(double y) {
        return this.y = y;
    }
}
