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

    /**
     * get the current hitbox
     * @return HitBox
     */
    public RectangleContainer getHitBox() {
        return hitBox;
    }

    /**
     * replace the current hitbox with a new one
     * @param hitBox the new hitbox
     */
    public void setHitBox(RectangleContainer hitBox) {
        this.hitBox = hitBox;
    }

    /**
     * get the X coordinate of the entity
     * @return X coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * set the X coordinate of the entity
     * @param x coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * get the Y coordinate of the entity
     * @return Y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * set the Y coordinate of the entity
     * @param y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * get the collision result for the entity combination
     * @param target
     * @return
     */
    public CollisionResult getCollision(CollisionTarget target) {
        return new Collision(this, target);
    }
}
