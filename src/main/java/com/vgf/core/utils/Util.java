package com.vgf.core.utils;

import com.raylib.Color;
import com.raylib.Vector2;

public class Util {

    //Make color from 4 integer - red, green, blue, alpha
    //Min -128 / Max +127
    public static Color makeColor(int r, int g, int b, int a){
        return new Color((byte) r, (byte) g, (byte) b, (byte) a);
    }
    //Add vec2 to vec1
    public static Vector2 addVector(Vector2 vec1, Vector2 vec2){
        vec1.setX(vec1.x()+vec2.x());
        vec1.setY(vec1.y()+vec2.y());
        return vec1;
    }
    public static Vector2 addVector(Vector2 vec1, Vector2 vec2,float mult){
        vec1.setX(vec1.x()+vec2.x()*mult);
        vec1.setY(vec1.y()+vec2.y()*mult);
        return vec1;
    }


}
