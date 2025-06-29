package com.viid.game.gameobjects;

import com.vgf.core.object.GameScene;

public class TestScene extends GameScene {


    @Override
    public void create(){
        addObject(new TestObject());
    }
}
