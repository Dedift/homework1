package com.company.homeworks.homework4;

public class Rectangle {
    private Point leftUP = new Point(7, 15);
    private Point rightDown = new Point(24, 8);

    public Rectangle(Point leftUP, Point rightDown) {
        this.leftUP = leftUP;
        this.rightDown = rightDown;
    }

    public Rectangle() {
    }

    public double getSquare() {
        Point leftDown = new Point(leftUP.getX(), rightDown.getY());
        return leftUP.distance(leftDown) * rightDown.distance(leftDown);
    }

    public double getPerimeter() {
        Point leftDown = new Point(leftUP.getX(), rightDown.getY());
        return (leftUP.distance(leftDown) + rightDown.distance(leftDown)) * 2;
    }

    public double GetDiagonal() {
        return leftUP.distance(rightDown);
    }

    public Point getLeftUpPoint() {
        return leftUP;
    }

    public Point setLeftUpPoint(Point leftUp) {
        return this.leftUP = leftUp;
    }

    public Point getRightDown() {
        return rightDown;
    }

    public Point setRightDown(Point rightDown) {
        return this.rightDown = rightDown;
    }
}
