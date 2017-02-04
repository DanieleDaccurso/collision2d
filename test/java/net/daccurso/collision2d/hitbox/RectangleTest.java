package net.daccurso.collision2d.hitbox;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by daniele on 21/01/2017.
 */
public class RectangleTest {
    @Test
    public void getName() throws Exception {
        Rectangle e = new Rectangle("Head", 10,10,10,10);
        assertEquals(e.getName(), "Head");
        e.setName("Leg");
        assertEquals(e.getName(), "Leg");
    }

    @Test
    public void getX() throws Exception {
        Rectangle e = new Rectangle(35,10,10,10);
        assertEquals(e.getX(), 35, 0.0);
        e.setX(20);
        assertEquals(e.getX(), 20, 0.0);
    }

    @Test
    public void getY() throws Exception {
        Rectangle e = new Rectangle(20,55,20,20);
        assertEquals(e.getY(), 55, 0.0);
        e.setY(123);
        assertEquals(e.getY(), 123, 0.0);
    }

    @Test
    public void getH() throws Exception {
        Rectangle e = new Rectangle(20,55,33,20);
        assertEquals(e.getH(), 33, 0.0);
        e.setH(99);
        assertEquals(e.getH(), 99, 0.0);
    }

    @Test
    public void getW() throws Exception {
        Rectangle e = new Rectangle(19,22,12,94);
        assertEquals(e.getW(), 94, 0.0);
        e.setW(12);
        assertEquals(e.getW(), 12, 0.0);
    }

}