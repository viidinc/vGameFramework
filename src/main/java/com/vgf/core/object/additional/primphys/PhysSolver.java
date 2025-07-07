package com.vgf.core.object.additional.primphys;

import com.raylib.Raylib;
import com.vgf.core.object.GameObject;
import com.vgf.core.object.additional.interfaces.Collider;

import java.util.ArrayList;

public class PhysSolver extends GameObject {
    private ArrayList<Collider> colliders = new ArrayList<>();

    public void addCollider(Collider coll){
        colliders.add(coll);
    }

    @Override
    public void tick() {
        super.tick();
        colliders.removeIf(coll->((GameObject)(coll)).isShouldDestroy());
        for (Collider coll : colliders){

            for (Collider otherColl : colliders){

                if (otherColl == coll){continue;}
                if (Raylib.checkCollisionCircles(coll.getPos(),coll.getRadius(),otherColl.getPos(),otherColl.getRadius())){
                    otherColl.hit((GameObject) coll);
                    coll.hit((GameObject) otherColl);
                }
            }
        }
    }
}
