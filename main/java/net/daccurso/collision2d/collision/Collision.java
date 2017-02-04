package net.daccurso.collision2d.collision;

import net.daccurso.collision2d.entity.CollisionProvider;
import net.daccurso.collision2d.entity.CollisionTarget;
import net.daccurso.collision2d.entity.Hittable;
import net.daccurso.collision2d.hitbox.Rectangle;

import java.util.List;

public class Collision implements CollisionResult {
    private CollisionProvider provider;
    private CollisionTarget target;

    public Collision(CollisionProvider provider, CollisionTarget target) {
        this.provider = provider;
        this.target = target;
    }

    public boolean hastSoftContact() {
        return false;
    }

    public boolean hasHardContact() {
        return false;
    }

    public List<CoordinatePoint> calculatePoints() {
        return null;
    }

    private Rectangle convertHittableToRectangle(Hittable entity) {
        return new Rectangle(entity.getX(), entity.getY(), entity.getHixBox().getW(), entity.getHixBox().getH());
    }
}
