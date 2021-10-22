package com.company.homeworks.homework5.closedshapes;

public abstract class AbstractClosedShape implements Сlosable {

    public boolean squaresIsEquals(AbstractClosedShape anyShape) {
        return this.getSquare() == anyShape.getSquare();
    }

    public boolean perimeterIsEquals(AbstractClosedShape anyShape) {
        return this.getSquare() == anyShape.getSquare();
    }

}
