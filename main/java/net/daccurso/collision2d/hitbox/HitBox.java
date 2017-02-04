package net.daccurso.collision2d.hitbox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HitBox implements RectangleContainer {
    /**
     * Default rectangle list is an ArrayList initialized with 10 places.
     * If you have very complex shapes, you might want to initialize the List outside
     * of the class with optimized settings, and use setRectangles
     */
    private List<PositionedRectangle> rectangles = new ArrayList<PositionedRectangle>(10);

    /**
     * Automatically calculated width
     */
    private double w;

    /**
     * Automatically calculated height
     */
    private double h;

    /**
     * Get the list of rectangles contained by this HitBox
     *
     * @return
     */
    public List<PositionedRectangle> getRectangles() {
        return rectangles;
    }

    /**
     * Set the whole list of Rectangles. Use this to override the List
     * if you want to use another implementation of List or set a big number of Rectangles
     *
     * @param rectangles
     */
    public void setRectangles(List<PositionedRectangle> rectangles) {
        this.rectangles = rectangles;
        this.refreshHitBoxSize();
    }

    /**
     * Add a Rectangle to the List
     *
     * @param rectangle
     */
    public void addRectangle(PositionedRectangle rectangle) {
        this.rectangles.add(rectangle);
        this.refreshHitBoxSizeByRectangle(rectangle);
    }

    /**
     * Remove Rectangle from List. For more complex List options, use getRectangles() instad
     * and work directly on the List.
     *
     * @param rectangle
     */
    public void removeRectangle(PositionedRectangle rectangle) {
        this.rectangles.remove(rectangle);
        this.refreshHitBoxSize();
    }

    /**
     * Get the current with of the HitBox. Note that this value dynamically changes when adding or removing
     * Rectangles.
     *
     * @return
     */
    public double getW() {
        return w;
    }

    /**
     * Get the current height of the HitBox. Note that this value dynamically changes when adding or removing
     * Rectangles.
     *
     * @return
     */
    public double getH() {
        return h;
    }

    /**
     * Refresh the size of the HitBox
     */
    private void refreshHitBoxSize() {
        this.w = 0;
        this.h = 0;

        Iterator<PositionedRectangle> rectangleIterator = this.rectangles.iterator();

        while(rectangleIterator.hasNext()) {
            PositionedRectangle current = rectangleIterator.next();
            this.refreshHitBoxSizeByRectangle(current);
        }
    }

    /**
     * Changes the size of the Hitbox, if the new given Rectangle would expand the current
     * maximum sizes.
     *
     * @param rectangle
     */
    private void refreshHitBoxSizeByRectangle(PositionedRectangle rectangle) {
        double currentWidth = rectangle.getW() + rectangle.getX();
        double currentHeight = rectangle.getH() + rectangle.getY();

        this.w = currentWidth > this.w ? currentWidth : this.w;
        this.h = currentHeight > this.h ? currentHeight : this.h;
    }
}
