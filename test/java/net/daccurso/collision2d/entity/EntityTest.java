package net.daccurso.collision2d.entity;

import net.daccurso.collision2d.hitbox.HitBox;
import net.daccurso.collision2d.hitbox.Rectangle;
import net.daccurso.collision2d.hitbox.RectangleContainer;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntityTest {
    @Test
    public void getHitBox() throws Exception {
        Entity e = new Entity();
        assertTrue(e.getHitBox() instanceof RectangleContainer);
        e.getHitBox().addRectangle(new Rectangle(90,90,90,90));

        HitBox h = new HitBox();
        h.addRectangle(new Rectangle(20,20,20,20));

        assertEquals(e.getHitBox().getW(), 180, 0.0);
        e.setHitBox(h);
        assertEquals(e.getHitBox().getW(), 40, 0.0);
    }

    @Test
    public void getX() throws Exception {
        Entity e = new Entity();
        e.setX(30);
        assertEquals(e.getX(), 30, 0.0);

        e.setX(20);
        assertEquals(e.getX(), 20, 0.0);
    }

    @Test
    public void getY() throws Exception {
        Entity e = new Entity();
        e.setY(30);
        assertEquals(e.getY(), 30, 0.0);

        e.setY(20);
        assertEquals(e.getY(), 20, 0.0);
    }

    @Test
    public void checkCollision() throws Exception {

    }

}