package net.daccurso.collision2d.collision;

public class Line {
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * get the X start point of the Line
     * @return x start point
     */
    public double getX1() {
        return x1;
    }

    /**
     * get the Y start point of the Line
     * @return y start point
     */
    public double getY1() {
        return y1;
    }

    /**
     * get the X end point of the Line
     * @return x end point
     */
    public double getX2() {
        return x2;
    }

    /**
     * get the Y end point of the Line
     * @return y end point
     */
    public double getY2() {
        return y2;
    }

    /**
     *
     * @return string interpretation of Line
     */
    public String toString() {
        return "("+this.x1+"/"+this.y1+")"+
                "/("+this.x2+"/"+this.y2+")";
    }
}
