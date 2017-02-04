package net.daccurso.collision2d.collision;

import java.util.List;

public interface CollisionResult {
    boolean hasSoftContact();
    boolean hasHardContact();

    List<CoordinatePoint> calculatePoints();
}
