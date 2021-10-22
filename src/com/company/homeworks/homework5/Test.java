package com.company.homeworks.homework5;

import com.company.homeworks.homework5.closedshapes.Point;
import com.company.homeworks.homework5.closedshapes.ShapeUtils;
import com.company.homeworks.homework5.closedshapes.circles.Circle;
import com.company.homeworks.homework5.closedshapes.circles.Ellipse;
import com.company.homeworks.homework5.closedshapes.quadrangles.Foursquare;
import com.company.homeworks.homework5.closedshapes.quadrangles.Rectangle;
import com.company.homeworks.homework5.closedshapes.quadrangles.Rhomb;
import com.company.homeworks.homework5.closedshapes.triangles.IsoscelesTriangle;
import com.company.homeworks.homework5.closedshapes.triangles.RightTriangle;

public class Test {

    public static void main(String[] args) {
        Ellipse circle = new Circle(new Point(21, 42), 5);
        System.out.println("Длина окружности = " + circle.getPerimeter());
        circle.printRadius();

        Ellipse ellipse = new Ellipse(10, 13, new Point(1, 23));
        System.out.println("Площадь эллипса = " + ellipse.getSquare());
        System.out.println("Вертикальная полуось эллипса = " + ellipse.getVerticalSemiaxis());

        Rectangle foursquare = new Foursquare(new Point(12, 2), 4);
        System.out.println("Диагональ квадрата = " + foursquare.getDiagonal());
        System.out.println("Периметр квадрата = " + foursquare.getPerimeter());

        Foursquare secondFoursquare = new Foursquare(new Point(41, 23), 8);
        System.out.println("Радиус описанной окружности около второго квадрата = " +
                secondFoursquare.getRadiusOfTheCircumscribedCircle());
        System.out.println("Радиус вписанной окружности во второй квадрат = " +
                secondFoursquare.getInscribedCircleRadius());

        Rhomb rhomb = new Rhomb(new Point(12, 23), new Point(14, 42));
        System.out.println("Площадь ромба = " + rhomb.getSquare());
        System.out.println("Горизонтальная диагональ ромба = " + rhomb.getHorizontalDiagonal());

        IsoscelesTriangle isoscelesTriangle = new IsoscelesTriangle(new Point(12, 32), new Point(15, 43));
        System.out.println("Высота равнобедренного треугольника по основанию = " +
                isoscelesTriangle.getBaseHeight());
        System.out.println("Радиус вписанной окружности в равнобедренный треугольник = " +
                isoscelesTriangle.getInscribedCircleRadius());

        RightTriangle rightTriangle = new RightTriangle(new Point(10, 14), 3, 4);
        System.out.println("Площадь прямоугольного треугольника = " + rightTriangle.getSquare());
        rightTriangle.setSideLegLength(14);
        System.out.println("Площадь прямоугольного треугольника после изменения катета = " +
                rightTriangle.getSquare());

        System.out.println("Квадрат является прямоугольником = " + ShapeUtils.isRectangle(foursquare));
        System.out.println("Круг является треугольником = " + ShapeUtils.isTriangle(circle));
        System.out.println("Квадрат равен второму квадрату = " + foursquare.equals(secondFoursquare));
        System.out.println("Площади круга и ромба равны = " + circle.squaresIsEquals(rhomb));
    }
}
