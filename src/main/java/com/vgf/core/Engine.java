package com.vgf.core;

import com.raylib.Raylib;
import com.vgf.core.object.GameScene;

import java.awt.*;


public class Engine {

    private static boolean shouldEndGame = false;



    public static void StartMainLoop(GameScene rootScene){
        //Before starting logic
        initWindow(640,480,"vGameFramework");
        Raylib.setTargetFPS(60);
        rootScene.create();
        //Main game loop
        while (!shouldEndGame){
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

    public void endGame(){
        shouldEndGame = true;
    }

    private static void initWindow(int height, int width,String title){
        Raylib.initWindow(height,width,title);
    }

}
