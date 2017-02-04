package net.daccurso.collision2d.hitbox;

public class Rectangle implements PositionedRectangle {
    private String name = null;
    private double x;
    private double y;
    private double h;
    private double w;

    public Rectangle(String name, double x, double y, double h, double w) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
    }

    public Rectangle(double x, double y, double h, double w) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }
}
