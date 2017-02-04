package net.daccurso.collision2d.entity;

import net.daccurso.collision2d.collision.Collision;
import net.daccurso.collision2d.collision.CollisionResult;
import net.daccurso.collision2d.hitbox.HitBox;
import net.daccurso.collision2d.hitbox.RectangleContainer;

public class Entity implements CollisionProvider, CollisionTarget{
    /**
     * Setting the HitBox in advance is necessary to maintain a valid state
     */
    private RectangleContainer hitBox = new HitBox();

    private double x;
    private double y;

    public RectangleContainer getHitBox() {
        return hitBox;
    }

    public void setHitBox(RectangleContainer hitBox) {
        this.hitBox = hitBox;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public CollisionResult checkCollision(CollisionTarget target) {
        return new Collision(this, target);
    }
}
