package net.daccurso.collision2d.hitbox;

import org.junit.Test;
import org.w3c.dom.css.Rect;

import javax.swing.text.Position;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class HitBoxTest {
    @Test
    public void getRectangles() throws Exception {
        HitBox h = new HitBox();

        h.addRectangle(new Rectangle(10,10,10,10));
        h.addRectangle(new Rectangle(10,10,10,10));
        h.addRectangle(new Rectangle(10,10,10,10));
        h.addRectangle(new Rectangle(10,10,10,10));
        h.addRectangle(new Rectangle(10,10,10,10));

        assertEquals(h.getRectangles().size(), 5);
    }

    @Test
    public void setRectangles() throws Exception {
        LinkedList<PositionedRectangle> l = new LinkedList<PositionedRectangle>();
        l.add(new Rectangle(10,10,10,10));

        HitBox h = new HitBox();
        h.setRectangles(l);

        assertTrue(h.getRectangles() instanceof LinkedList);
    }

    @Test
    public void addRectangle() throws Exception {
        HitBox h = new HitBox();

        h.addRectangle(new Rectangle(10,10,10,10));

        assertEquals(h.getRectangles().size(), 1);
    }

    @Test
    public void removeRectangle() throws Exception {
        HitBox h = new HitBox();

        Rectangle r = new Rectangle(10,10,10,10);

        h.addRectangle(r);
        h.removeRectangle(r);

        assertEquals(h.getRectangles().size(), 0);
    }

    @Test
    public void getW() throws Exception {
        HitBox h = new HitBox();

        h.addRectangle(new Rectangle(10,10,10,10));
        assertEquals(h.getW(), 20, 0.0);

        h.addRectangle(new Rectangle(20,10,10,10));
        assertEquals(h.getW(), 30, 0.0);

        LinkedList<PositionedRectangle> l = new LinkedList<PositionedRectangle>();
        Rectangle e =  new Rectangle(20,10,10,20);
        l.add(e);
        h.setRectangles(l);
        assertEquals(h.getW(), 40, 0.0);

        h.addRectangle(new Rectangle(10,10,10,10));
        assertEquals(h.getW(), 40, 0.0);

        h.removeRectangle(e);
        assertEquals(h.getW(), 20, 0.0);
    }

    @Test
    public void getH() throws Exception {
        HitBox h = new HitBox();

        h.addRectangle(new Rectangle(10,10,10,10));

        assertEquals(h.getH(), 20, 0.0);

        h.addRectangle(new Rectangle(10,20,10,10));

        assertEquals(h.getH(), 30, 0.0);

        LinkedList<PositionedRectangle> l = new LinkedList<PositionedRectangle>();
        l.add(new Rectangle(20,30,30,20));
        h.setRectangles(l);

        assertEquals(h.getH(), 60, 0.0);
    }

}