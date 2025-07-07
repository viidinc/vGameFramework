package com.viid.game.gameobjects;

import com.raylib.Raylib;
import com.raylib.Vector2;
import com.vgf.core.object.GameObject;
import com.vgf.core.object.additional.interfaces.Collider;
import com.viid.game.gameobjects.player.Player;

public class TestCollision extends GameObject implements Collider {

    Vector2 position = new Vector2(500,500);

    @Override
    public float getRadius() {
        return 32;
    }

    @Override
    public Vector2 getPos() {
        return position;
    }

    @Override
    public void hit(GameObject object) {
        if (object instanceof Player){
            ((Player) object).TakeDamage(1);
        }
    }

    @Override
    public void create() {
        super.create();
        TestScene.mainPhysSolver.addCollider(this);
    }

    @Override
    public void draw() {
        Raylib.drawCircleV(position,getRadius(),Raylib.BLUE);
    }

    @Override
    public void tick() {
        super.tick();
        position.x((float) (position.x() + Math.sin(TestScene.mainDefCaller.currentFrame*0.01)*2.0));
    }
}
