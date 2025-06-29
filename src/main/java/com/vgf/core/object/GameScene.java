package com.vgf.core.object;

import java.util.ArrayList;

public class GameScene extends GameObject{

    ArrayList<GameObject> objects = new ArrayList<GameObject>();
    ArrayList<GameObject> deferredAdd = new ArrayList<GameObject>();

    //Add object on next frame
    public void addObject(GameObject gameObject){
        deferredAdd.add(gameObject);
    }


    @Override
    public void tick(){
        //Clear destroyed objects
        objects.removeIf(GameObject::isShouldDestroy);

        //Add deferred added objects
        if (!deferredAdd.isEmpty()){
            for (GameObject gameObject : deferredAdd){
                objects.add(gameObject);
                gameObject.create();
            }
        }
        deferredAdd.clear();

        //Tick logic
        for(GameObject gameObject : objects){
            gameObject.tick();
        }
    }

    @Override
    public void fixedTick(){
        for(GameObject gameObject : objects){
            gameObject.fixedTick();
        }
    }
    @Override
    public void draw(){
        for(GameObject gameObject : objects){
            gameObject.draw();
        }
    }

}
