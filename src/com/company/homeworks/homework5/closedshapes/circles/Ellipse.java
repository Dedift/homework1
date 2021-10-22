package com.company.homeworks.homework5.closedshapes.circles;

import com.company.homeworks.homework5.closedshapes.AbstractClosedShape;
import com.company.homeworks.homework5.closedshapes.Point;

public class Ellipse extends AbstractClosedShape implements Rounded {

    protected Point centerPoint;
    private double horizontalSemiaxis;
    private double verticalSemiaxis;

    public Ellipse(double horizontalSemiaxis, double verticalSemiaxis, Point centerPoint) {
        if (horizontalSemiaxis > 0 && verticalSemiaxis > 0) {
            this.horizontalSemiaxis = horizontalSemiaxis;
            this.verticalSemiaxis = verticalSemiaxis;
            this.centerPoint = centerPoint;
        } else System.out.println("Горизонтальная и вертикальная оси не можгут быть равны нулю или меньше нуля!");
    }

    @Override
    public void printRadius() {
        System.out.println("Горизонтальная полуось = " + horizontalSemiaxis +
                " , вертикальная полуось = " + verticalSemiaxis);
    }

    @Override
    public double getSquare() {
        return Pi * verticalSemiaxis * horizontalSemiaxis;
    }

    @Override
    public double getPerimeter() {
        return 2 * Pi * Math.sqrt((verticalSemiaxis * verticalSemiaxis + horizontalSemiaxis * horizontalSemiaxis) / 2);
    }

    @Override
    public Point getCenterPoint() {
        return centerPoint;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "centerPoint=" + centerPoint +
                ", horizontalSemiaxis=" + horizontalSemiaxis +
                ", verticalSemiaxis=" + verticalSemiaxis +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ellipse ellipse = (Ellipse) o;

        if (Double.compare(ellipse.horizontalSemiaxis, horizontalSemiaxis) != 0) return false;
        return Double.compare(ellipse.verticalSemiaxis, verticalSemiaxis) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(horizontalSemiaxis);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(verticalSemiaxis);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public double getHorizontalSemiaxis() {
        return horizontalSemiaxis;
    }

    public void setHorizontalSemiaxis(double horizontalSemiaxis) {
        if (horizontalSemiaxis > 0) {
            this.horizontalSemiaxis = horizontalSemiaxis;
        } else System.out.println("Горизонтальная ось не может быть равна нулю или меньше нуля!");
    }

    public double getVerticalSemiaxis() {
        return verticalSemiaxis;
    }

    public void setVerticalSemiaxis(double verticalSemiaxis) {
        if (verticalSemiaxis > 0) {
            this.verticalSemiaxis = verticalSemiaxis;
        } else System.out.println("Вертикальная ось не может быть равна нулю или меньше нуля!");
    }
}
