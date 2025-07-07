package com.viid.game.gameobjects;

import com.vgf.core.object.GameScene;
import com.vgf.core.object.additional.deferredcalls.DeferredCaller;
import com.vgf.core.object.additional.primphys.PhysSolver;
import com.viid.game.gameobjects.player.Player;

public class TestScene extends GameScene {


    public static PhysSolver mainPhysSolver = new PhysSolver();
    public static DeferredCaller mainDefCaller = new DeferredCaller();
    @Override
    public void create(){
        addObject(mainPhysSolver);
        addObject(mainDefCaller);
        addObject(new Player());
        addObject(new TestCollision());

    }
}
