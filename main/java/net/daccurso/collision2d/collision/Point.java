package net.daccurso.collision2d.collision;

public class Point implements CoordinatePoint {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public String toString() {
        return "X = "+this.getX()+" / Y = "+this.getY();
    }
}
