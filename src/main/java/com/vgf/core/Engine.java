package com.vgf.core;

import com.raylib.Raylib;
import com.vgf.core.object.GameScene;

public class Engine {

    private static boolean shouldEndGame = false;

    public static void StartMainLoop(GameScene rootScene){
        //Before starting logic
        initWindow(1280,720,"vGameFramework");


        Raylib.setTargetFPS(60);
        rootScene.create();
        //Main game loop
        while (!shouldEndGame && !Raylib.windowShouldClose()){
            rootScene.tick();
            rootScene.fixedTick();
            Raylib.beginDrawing();
            Raylib.clearBackground(Raylib.BLACK);
            rootScene.draw();
            Raylib.endDrawing();
        }

        //End game logic
        Raylib.closeWindow();
    }

    public static void endGame(){
        shouldEndGame = true;
    }

    private static void initWindow(int height, int width,String title){
        Raylib.initWindow(height,width,title);
    }

}
