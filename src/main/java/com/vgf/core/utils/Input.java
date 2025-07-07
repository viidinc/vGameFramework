package com.vgf.core.utils;

import com.raylib.Raylib;
import com.raylib.Vector2;

public class Input {

    public static Action moveUp = new Action(Raylib.KeyboardKey.KEY_W);
    public static Action moveDown = new Action(Raylib.KeyboardKey.KEY_S);
    public static Action moveLeft = new Action(Raylib.KeyboardKey.KEY_D);
    public static Action moveRight = new Action(Raylib.KeyboardKey.KEY_A);
    public static Action dash = new Action(Raylib.KeyboardKey.KEY_SPACE);

    public static class Action{
        public int key;

        Action(int key){
            this.key = key;
        }
        public void setKey(int key){
            this.key = key;
        }
        public boolean pressed(){
            return Raylib.isKeyPressed(key);
        }
        public boolean pressedRepeat(){
            return Raylib.isKeyPressedRepeat(key);
        }
        public boolean down(){
            return Raylib.isKeyDown(key);
        }
        public boolean released(){
            return Raylib.isKeyReleased(key);
        }
        public boolean up(){
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
        return new Vector2(x,y);
    }

}
