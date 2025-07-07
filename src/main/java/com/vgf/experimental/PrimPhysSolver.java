package com.vgf.experimental;

import com.vgf.core.object.GameObject;
import com.vgf.core.utils.Util;

import java.util.ArrayList;

public class PrimPhysSolver extends GameObject {
    protected ArrayList<PrimPhysed> physObjects = new ArrayList<>();

    public void addObject(PrimPhysed obj){
        physObjects.add(obj);
    }
    public void solvePhys(){
        for (PrimPhysed obj : physObjects){
            for (PrimPhysed otherObj : physObjects){
                if (otherObj == obj){continue;}
                if (Util.getDistance(obj.getX(),obj.getY(),otherObj.getX(),otherObj.getY())<obj.getCollRadius()){
                    obj.onHit(otherObj);
                    otherObj.onHit(obj);
                }
            }
        }
    }

}
