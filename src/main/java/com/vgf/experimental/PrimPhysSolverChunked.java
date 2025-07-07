package com.vgf.experimental;

import com.vgf.core.utils.Util;

import java.util.ArrayList;
import java.util.HashMap;

public class PrimPhysSolverChunked extends PrimPhysSolver {
    private HashMap<Integer, ArrayList<PrimPhysed>> chunks = new HashMap();

    final float CHUNK_WIDTH = 1024;
    final float CHUNK_HEIGHT = 1024;

    @Override
    public void tick() {
        super.tick();
        dist();
        solvePhys();
    }
    @Override
    public void solvePhys(){
        //For all chunks
        for (ArrayList<PrimPhysed> list : chunks.values()){
            //For all objects in one chunk
            for (PrimPhysed obj : list){
                //For OTHER objects in the chunk
                for (PrimPhysed otherObj : list){
                    if (obj.equals(otherObj)){
                        continue;
                    }
                    if (Util.getDistance(obj.getX(),obj.getY(),otherObj.getX(),otherObj.getY())<obj.getCollRadius()){
                        obj.onHit(otherObj);
                        otherObj.onHit(obj);
                    }
                }
            }
        }
    }
    //Distibute object into different listis
    public void dist(){

        for (PrimPhysed obj : physObjects){

            int chunkX =  (int)(obj.getX() / CHUNK_WIDTH);
            int chunkY =  (int)(obj.getY() / CHUNK_HEIGHT);

            int key = chunkX*10+chunkY;

            ArrayList<PrimPhysed> list;

            if (!chunks.containsKey(key)){
                list = new ArrayList<>();
                chunks.put(key,list);
            }
            list = chunks.get(key);
            list.add(obj);

        }


    }

}
