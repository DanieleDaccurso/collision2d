package net.daccurso.collision2d.collision;

public class Point implements CoordinatePoint {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get the X coordinate of the Point
     * @return X coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     * get the Y coordinate of the Point
     * @return y coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     *
     * @return string interpretation of Point
     */
    public String toString() {
        return "X = "+this.getX()+" / Y = "+this.getY();
    }
}
