package com.vgf.core.utils;

import com.raylib.Raylib;
import com.raylib.Vector2;

public class Input {

    public static Action moveUp = new Action(Raylib.KeyboardKey.KEY_W);
    public static Action moveDown = new Action(Raylib.KeyboardKey.KEY_S);
    public static Action moveLeft = new Action(Raylib.KeyboardKey.KEY_D);
    public static Action moveRight = new Action(Raylib.KeyboardKey.KEY_A);

    public static class Action{
        public int key;

        Action(int key){
            this.key = key;
        }
        public void setKey(int key){
            this.key = key;
        }
        boolean pressed(){
            return Raylib.isKeyPressed(key);
        }
        boolean pressedRepeat(){
            return Raylib.isKeyPressedRepeat(key);
        }
        boolean down(){
            return Raylib.isKeyDown(key);
        }
        boolean released(){
            return Raylib.isKeyReleased(key);
        }
        boolean up(){
            return Raylib.isKeyUp(key);
        }
    }

    public static Vector2 getVector(Action positiveY, Action negativeY, Action positiveX, Action negativeX){
        int x = 0;
        int y = 0;

        if (positiveY.down() != negativeY.down()){
            y = positiveY.down() ? 1 : -1;
        }
        if (positiveX.down() != negativeX.down()){
            x = positiveX.down() ? -1 : 1;
        }
        System.out.println(x);
        System.out.println(y);
        return new Vector2(x,y);
    }

}
