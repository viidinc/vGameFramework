package com.viid.game.gameobjects;

import com.raylib.Color;
import com.raylib.Raylib;
import com.raylib.Vector2;
import com.vgf.core.object.GameObject;
import com.vgf.core.object.additional.deferredcalls.DeferredCaller;
import com.vgf.core.object.additional.interfaces.Collider;
import com.vgf.core.object.additional.interfaces.Damageble;
import com.vgf.core.utils.Input;
import com.vgf.core.utils.Util;


public class Character extends GameObject implements Collider, Damageble {

    Vector2 position = new Vector2(0,0);

    float speed = 10.0f;
    public int health = 3;
    public boolean isInvul = false;
    public Vector2 dashedPos = null;

    public Color defaultPlayerColor = Util.makeColor(255,0,0,255);
    public Color damagedPlayerColor = Util.makeColor(255,0,0,255);

    public void Move(Vector2 by){
        Util.addVector(position,by,speed);
    }

    @Override
    public void tick() {
        super.tick();
        Vector2 moveVector = Input.getVector(Input.moveDown,Input.moveUp,Input.moveRight,Input.moveLeft);
        if (Input.dash.pressed()){
            dashedPos = Util.copyVector(position);
            Util.multVector(moveVector,18.0f);
        }
        Move(moveVector);

        if (isInvul){
            damagedPlayerColor.a((byte) ((Math.cos(TestScene.mainDefCaller.currentFrame*0.2)+1.5)*127));
            damagedPlayerColor.r((byte) ((Math.sin(TestScene.mainDefCaller.currentFrame*0.2)+1.5)*127));
            damagedPlayerColor.g((byte) ((Math.sin(TestScene.mainDefCaller.currentFrame*0.2)+1.5)*127));
            damagedPlayerColor.b((byte) ((Math.sin(TestScene.mainDefCaller.currentFrame*0.2)+1.5)*127));
        }
    }

    @Override
    public void draw() {
        super.draw();
        if (isInvul){
            Raylib.drawCircleV(position,16.0f, damagedPlayerColor);}
        else {
            Raylib.drawCircleV(position,16.0f, defaultPlayerColor);}
        if (dashedPos != null){
            Raylib.drawLineEx(dashedPos,position,8,defaultPlayerColor);

            dashedPos = null;
        }
        Raylib.drawText("Health: "+health,10,30,16,Raylib.RED);
    }

    @Override
    public float getRadius() {
        return 16;
    }

    @Override
    public Vector2 getPos() {
        return position;
    }

    @Override
    public void create() {
        super.create();
        TestScene.mainPhysSolver.addCollider(this);
    }

    @Override
    public void hit(GameObject object) {
    }
    @Override
    public void TakeDamage(int dmg){
        if (isInvul){return;}
        health = Math.clamp(health-dmg,0,999999999);
        isInvul = true;
        TestScene.mainDefCaller.addTask(()->{isInvul = false;},60);
    }

}
