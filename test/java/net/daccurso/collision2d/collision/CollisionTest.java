package net.daccurso.collision2d.collision;

import net.daccurso.collision2d.entity.Entity;
import net.daccurso.collision2d.hitbox.Rectangle;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CollisionTest {

    @Test
    public void hasSoftContact() throws Exception {
        Entity provider = new Entity();

        provider.setX(0);
        provider.setY(0);
        provider.getHitBox().addRectangle(new Rectangle(0,0,100,100));

        Entity target = new Entity();
        target.setX(20);
        target.setY(20);
        target.getHitBox().addRectangle(new Rectangle(10,10,40,40));

        CollisionResult c = provider.getCollision(target);

        assertTrue(c.hasSoftContact());

        target.setX(200);
        target.setY(200);

        assertFalse(c.hasSoftContact());
    }

    @Test
    public void hasHardContact() throws Exception {
        Entity provider = new Entity();

        provider.setX(0);
        provider.setY(0);
        provider.getHitBox().addRectangle(new Rectangle(0,0,100,100));

        Entity target = new Entity();
        target.setX(20);
        target.setY(20);
        target.getHitBox().addRectangle(new Rectangle(10,10,40,40));

        CollisionResult c = provider.getCollision(target);

        assertTrue(c.hasHardContact());

        target.setX(200);
        target.setY(200);

        assertFalse(c.hasHardContact());

        provider.getHitBox().addRectangle(new Rectangle(300, 0, 1, 1));
        provider.getHitBox().addRectangle(new Rectangle(0, 300, 1, 1));

        assertTrue(c.hasSoftContact());
        assertFalse(c.hasHardContact());
    }

    @Test
    public void calculatePoints() throws Exception {
        Entity e = new Entity();
        e.getHitBox().addRectangle(new Rectangle(0,0,100,100));

        Entity f = new Entity();
        f.getHitBox().addRectangle(new Rectangle(50,50,200,200));

        CollisionResult r = e.getCollision(f);

        List<CoordinatePoint> points = r.calculatePoints();
        CoordinatePoint first = points.get(0);
        assertEquals(first.getX(), 100, 0.0);
        assertEquals(first.getY(), 50, 0.0);

        CoordinatePoint second = points.get(1);
        assertEquals(second.getX(), 50, 0.0);
        assertEquals(second.getY(), 100, 0.0);
    }

}