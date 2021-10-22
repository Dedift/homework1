package com.company.homeworks.homework5.closedshapes.triangles;

import com.company.homeworks.homework5.closedshapes.AbstractClosedShape;
import com.company.homeworks.homework5.closedshapes.Point;

public class RightTriangle extends AbstractClosedShape implements Triangulable {

    private Point leftPoint;
    private Point upPoint;
    private Point rightPoint;
    private double legLengthAtBase;
    private double sideLegLength;

    public RightTriangle(Point leftPoint, double legLengthAtBase, double sideLegLength) {
        if (legLengthAtBase > 0 && sideLegLength > 0) {
            this.leftPoint = leftPoint;
            this.legLengthAtBase = legLengthAtBase;
            this.sideLegLength = sideLegLength;
            this.rightPoint = new Point(leftPoint.getX() + legLengthAtBase, leftPoint.getY());
            this.upPoint = new Point(leftPoint.getX(), leftPoint.getY() + sideLegLength);
        } else System.out.println("Длины катетов не могут быть равны нулю или меньше нуля!");
    }

    @Override
    public Point getCenterPoint() {
        return new Point(leftPoint.getX() + legLengthAtBase / 2,
                leftPoint.getY() + sideLegLength / 2);
    }

    public double getHypotenuse() {
        return Math.sqrt(legLengthAtBase * legLengthAtBase +
                sideLegLength * sideLegLength);
    }

    @Override
    public double getInscribedCircleRadius() {
        return (legLengthAtBase + sideLegLength - getHypotenuse() / 2);
    }

    public double radiusOfTheCircumscribedCircle() {
        return 1 / 2 * Math.sqrt(legLengthAtBase * legLengthAtBase +
                sideLegLength * sideLegLength);
    }

    @Override
    public double getBaseHeight() {
        return sideLegLength;
    }

    @Override
    public double getPerimeter() {
        return legLengthAtBase + sideLegLength + getHypotenuse();
    }

    @Override
    public double getSquare() {
        return legLengthAtBase * sideLegLength / 2;
    }

    @Override
    public String toString() {
        return "RightTriangle{" +
                "leftPoint=" + leftPoint +
                ", upPoint=" + upPoint +
                ", rightPoint=" + rightPoint +
                ", legLengthAtBase=" + legLengthAtBase +
                ", sideLegLength=" + sideLegLength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RightTriangle that = (RightTriangle) o;

        if (Double.compare(that.legLengthAtBase, legLengthAtBase) != 0) return false;
        return Double.compare(that.sideLegLength, sideLegLength) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(legLengthAtBase);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideLegLength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Point getLeftPoint() {
        return leftPoint;
    }

    public void setLeftPoint(Point leftPoint) {
        this.leftPoint = leftPoint;
        this.rightPoint = new Point(leftPoint.getX() + legLengthAtBase, leftPoint.getY());
        this.upPoint = new Point(leftPoint.getX(), leftPoint.getY() + sideLegLength);
    }

    public Point getUpPoint() {
        return upPoint;
    }

    public Point getRightPoint() {
        return rightPoint;
    }

    public double getLegLengthAtBase() {
        return legLengthAtBase;
    }

    public void setLegLengthAtBase(double legLengthAtBase) {
        if (legLengthAtBase > 0) {
            this.legLengthAtBase = legLengthAtBase;
            this.rightPoint = new Point(leftPoint.getX() + legLengthAtBase, leftPoint.getY());
        } else System.out.println("Длина катета не может быть равна нулю или меньше нуля!");
    }

    public double getSideLegLength() {
        return sideLegLength;
    }

    public void setSideLegLength(double sideLegLength) {
        if (sideLegLength > 0) {
            this.sideLegLength = sideLegLength;
            this.upPoint = new Point(leftPoint.getX(), leftPoint.getY() + sideLegLength);
        } else System.out.println("Длина катета не может быть равна нулю или меньше нуля!");
    }
}

