package com.viid.game.gameobjects;

import com.raylib.Color;
import com.raylib.Raylib;
import com.raylib.Vector2;
import com.vgf.core.object.GameObject;
import com.vgf.core.utils.Input;
import com.vgf.core.utils.Util;

public class TestObject extends GameObject{


    private Color color = Util.makeColor(127,127,127,127);
    private Vector2 position = new Vector2(0,0);

    @Override
    public void tick() {
        super.tick();
        Util.addVector(position,Input.getVector(Input.moveDown,Input.moveUp,Input.moveRight,Input.moveLeft),10);
    }

    @Override
    public void draw(){
        Raylib.drawFPS(10,10);
        Raylib.drawCircleV(position,50,color);
    }
}
