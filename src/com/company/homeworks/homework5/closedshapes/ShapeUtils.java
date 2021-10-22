package com.company.homeworks.homework5.closedshapes;

import com.company.homeworks.homework5.closedshapes.circles.Rounded;
import com.company.homeworks.homework5.closedshapes.quadrangles.Rectangle;
import com.company.homeworks.homework5.closedshapes.triangles.Triangulable;

public final class ShapeUtils {

    private ShapeUtils() {
    }

    public static boolean isTriangle(AbstractClosedShape anyShape) {
        return anyShape instanceof Triangulable;
    }

    public static boolean isRectangle(AbstractClosedShape anyShape) {
        return anyShape instanceof Rectangle;
    }

    public static boolean isRounded(AbstractClosedShape anyShape) {
        return anyShape instanceof Rounded;
    }
}
