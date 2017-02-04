package net.daccurso.collision2d.collision;

import net.daccurso.collision2d.entity.CollisionProvider;
import net.daccurso.collision2d.entity.CollisionTarget;
import net.daccurso.collision2d.entity.Hittable;
import net.daccurso.collision2d.hitbox.PositionedRectangle;
import net.daccurso.collision2d.hitbox.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collision implements CollisionResult {
    private CollisionProvider provider;
    private CollisionTarget target;

    public Collision(CollisionProvider provider, CollisionTarget target) {
        this.provider = provider;
        this.target = target;
    }

    /**
     * Determines if the hitbox of the collision provider is hitting the
     * hitbox of the collision target
     * @return
     */
    public boolean hasSoftContact() {
        Rectangle rP = this.convertHittableToRectangle(this.provider);
        Rectangle rT = this.convertHittableToRectangle(this.target);

        return this.isHitting(rP, rT);
    }

    /**
     * Determines if a rectangle of the collision provider is hitting a rectangle
     * of the collision target
     * @return true when hitting, false when not
     */
    public boolean hasHardContact() {
        if(!this.hasSoftContact()) {
            return false;
        }

        Iterator<PositionedRectangle> pIt = this.provider.getHitBox().getRectangles().iterator();
        List<PositionedRectangle> targetRs = this.target.getHitBox().getRectangles();

        while(pIt.hasNext()) {
            PositionedRectangle currentP = this.createAbsoluteRectangle(this.provider, pIt.next());

            Iterator<PositionedRectangle> tIt = targetRs.iterator();
            while (tIt.hasNext()) {
                PositionedRectangle currentT = this.createAbsoluteRectangle(this.target, tIt.next());
                if(this.isHitting(currentP, currentT)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Returns the list of intersection points
     * @return
     */
    public List<CoordinatePoint> calculatePoints() {
        Iterator<PositionedRectangle> pIt = this.provider.getHitBox().getRectangles().iterator();
        List<PositionedRectangle> targetRs = this.target.getHitBox().getRectangles();

        List<CoordinatePoint> points = new ArrayList<CoordinatePoint>();

        while(pIt.hasNext()) {
            PositionedRectangle currentP = this.createAbsoluteRectangle(this.provider, pIt.next());
            Iterator<PositionedRectangle> tIt = targetRs.iterator();

            while (tIt.hasNext()) {
                PositionedRectangle currentT = this.createAbsoluteRectangle(this.target, tIt.next());

                if(this.isHitting(currentP, currentT)) {
                    Iterator<Line> providerIterator = this.convertRectangleToLines(currentP).iterator();
                    List<Line> targetLines = this.convertRectangleToLines(currentT);

                    while (providerIterator.hasNext()) {
                        Line currentLine = providerIterator.next();
                        Iterator<Line> targetIterator = targetLines.iterator();

                        while (targetIterator.hasNext()) {
                            Point p = this.calculateIntersection(currentLine, targetIterator.next());
                            if(p != null) {
                                points.add(p);
                            }
                        }
                    }
                }
            }
        }

        return points;
    }

    /**
     * Convert an hittable entity to a Rectangle
     * @param entity
     * @return
     */
    private Rectangle convertHittableToRectangle(Hittable entity) {
        return new Rectangle(entity.getX(), entity.getY(), entity.getHitBox().getW(), entity.getHitBox().getH());
    }

    /**
     * Create a Rectangle which is shifted by the position of the Entity
     * @param e
     * @param r
     * @return
     */
    private Rectangle createAbsoluteRectangle(Hittable e, PositionedRectangle r) {
        return new Rectangle(e.getX() + r.getX(), e.getY() + r.getY(), r.getH(), r.getW());
    }

    private List<Line> convertRectangleToLines(PositionedRectangle r) {
        ArrayList<Line> lines = new ArrayList<Line>(4);

        lines.add(new Line(r.getX(), r.getY(), r.getX(), r.getY() + r.getH()));
        lines.add(new Line(r.getX(), r.getY(), r.getX() + r.getW(), r.getY()));
        lines.add(new Line(r.getX() + r.getW(), r.getY(), r.getX() + r.getW(), r.getY() + r.getH()));
        lines.add(new Line(r.getX(), r.getY() + r.getH(), r.getX() + r.getW(), r.getY() + r.getH()));

        Iterator<Line> lineIterator = lines.iterator();
        while (lineIterator.hasNext()) {
            System.out.println(lineIterator.next());
        }

        System.out.println("-----");

        return lines;
    }

    /**
     *
     * Algorithm source: https://developer.mozilla.org/en-US/docs/Games/Techniques/2D_collision_detection
     * @param rP the provider rectangle
     * @param rT the target rectangle
     * @return
     */
    private boolean isHitting(PositionedRectangle rP, PositionedRectangle rT) {
        return ( rP.getX() < rT.getX() + rT.getW() &&
                rP.getX() + rP.getW() > rT.getX() &&
                rP.getY() < rT.getY() + rT.getH() &&
                rP.getH() + rP.getY() > rT.getY() );
    }

    /**
     * Algorithm source: http://stackoverflow.com/questions/16314069/calculation-of-intersections-between-line-segments
     * @param a
     * @param b
     * @return
     */
    private Point calculateIntersection(Line a, Line b) {
        System.out.println("Checking: "+a+" against: "+b);
        double d = (b.getY2() - b.getY1()) * (a.getX2() - a.getX1()) - (b.getX2() - b.getX1()) * (a.getY2() - a.getY1());
        if(d == 0.0) {
            return null;
        }

        double ua = ((b.getX2() - b.getX1()) * (a.getY1() - b.getY1()) - (b.getY2() - b.getY1()) * (a.getX1() - b.getX1()))/d;
        double ub = ((a.getX2() - a.getX1()) * (a.getY1() - b.getY1()) - (a.getY2() - a.getY1()) * (a.getX1() - b.getX1()))/d;

        if(ua > 0.0f && ua <= 1.0f && ub >= 0.0f && ub <= 1.0f) {

            Point p =  new Point(
                    a.getX1() + ua*(a.getX2() - a.getX1()),
                    a.getY1() + ua*(a.getY2() - a.getY1())
            );

            System.out.println("intersection: "+p);
            return p;
        }

        return null;
    }
}
