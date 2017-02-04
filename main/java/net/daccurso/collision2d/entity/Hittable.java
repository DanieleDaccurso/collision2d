package net.daccurso.collision2d.entity;

import net.daccurso.collision2d.hitbox.RectangleContainer;

public interface Hittable {
    RectangleContainer getHitBox();
    double getX();
    double getY();
}
