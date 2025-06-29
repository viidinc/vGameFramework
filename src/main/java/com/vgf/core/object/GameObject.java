package com.vgf.core.object;

public class GameObject {

    private boolean shouldDestroy = false;

    //Call once, when added to scene
    public void create(){}
    //Call every frame
    public void tick(){};
    //Trying to call fixed time in second
    public void fixedTick(){};
    //Calling when game can draw.
    public void draw(){};

    //Just set should destroy flag. Objects with this flag will be destroyed on next frame by engine.
    public void destroy(){shouldDestroy = true;};
    public boolean isShouldDestroy(){return shouldDestroy;};
}
