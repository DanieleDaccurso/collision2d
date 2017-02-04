package net.daccurso.collision2d.entity;

import net.daccurso.collision2d.collision.CollisionResult;

public interface CollisionProvider extends Hittable {
    CollisionResult getCollision(CollisionTarget e);
}
