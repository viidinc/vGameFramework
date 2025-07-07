package com.vgf.core.object.additional.interfaces;

import com.raylib.Vector2;
import com.vgf.core.object.GameObject;

public interface Collider {
    float getRadius();
    Vector2 getPos();
    default void hit(GameObject object){};

}
