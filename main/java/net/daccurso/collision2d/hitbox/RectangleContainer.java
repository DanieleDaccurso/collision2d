package net.daccurso.collision2d.hitbox;

import java.util.List;

public interface RectangleContainer {
    List<PositionedRectangle> getRectangles();
    void addRectangle(PositionedRectangle r);
    double getW();
    double getH();
}
