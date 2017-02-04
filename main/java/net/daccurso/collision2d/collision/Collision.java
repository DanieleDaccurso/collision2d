package net.daccurso.collision2d.collision;

import net.daccurso.collision2d.entity.CollisionProvider;
import net.daccurso.collision2d.entity.CollisionTarget;
import net.daccurso.collision2d.entity.Hittable;
import net.daccurso.collision2d.hitbox.PositionedRectangle;
import net.daccurso.collision2d.hitbox.Rectangle;

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
    public boolean hastSoftContact() {
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
        if(!this.hastSoftContact()) {
            return false;
        }

        Iterator<PositionedRectangle> pIt = this.provider.getHixBox().getRectangles().iterator();
        List<PositionedRectangle> targetRs = this.target.getHixBox().getRectangles();

        while(pIt.hasNext()) {
            PositionedRectangle currentP = pIt.next();

            Iterator<PositionedRectangle> tIt = targetRs.iterator();
            while (tIt.hasNext()) {
                if(this.isHitting(currentP, tIt.next())) {
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
        return null;
    }

    /**
     * Convert an hittable entity to a Rectangle
     * @param entity
     * @return
     */
    private Rectangle convertHittableToRectangle(Hittable entity) {
        return new Rectangle(entity.getX(), entity.getY(), entity.getHixBox().getW(), entity.getHixBox().getH());
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
}
