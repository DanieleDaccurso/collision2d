package net.daccurso.collision2d.collision;

import java.util.List;

public interface CollisionResult {
    boolean hastSoftContact();
    boolean hasHardContact();

    List<CoordinatePoint> calculatePoints();
}
