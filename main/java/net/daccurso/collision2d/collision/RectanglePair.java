package net.daccurso.collision2d.collision;

import net.daccurso.collision2d.hitbox.PositionedRectangle;

public interface RectanglePair {
    PositionedRectangle getProviderRectangle();
    PositionedRectangle getTargetRectangle();
}
