package com.vgf.core.object.additional.drawers;

import com.raylib.Color;
import com.raylib.Raylib;
import com.raylib.Vector2;
import com.vgf.core.object.GameObject;

import java.util.ArrayList;
import java.util.Optional;

public class Drawer extends GameObject {

    private ArrayList<vertex> vertices = new ArrayList<>();

    @Override
    public void draw() {
        super.draw();
        Raylib.rlBegin(6);
        for (vertex v : vertices){
            if (v.col.isPresent()){
                color c = v.col.get();
                Raylib.rlColor4f(c.r,c.g,c.b,c.a);}
            Raylib.rlVertex2f(v.x,v.y);
        }
        Raylib.rlEnd();
        vertices.clear();
    }
    private record vertex(float x, float y, Optional<color> col){}
    private record color(float r, float g, float b, float a){}

    public void addV(float x, float y){
        vertices.add(new vertex(x,y,null));
    }
    public void addVC(float x, float y, Color col){
        vertices.add(new vertex(x,y, Optional.of(makeColor(col))));
    }
    private color makeColor(Color col){
        return new color(col.r(),col.g(),col.b(),col.a());
    }

    //Draw commands

    public void drawLineGradient(Vector2 StartPos, Vector2 EndPos, float thick, Color col1, Color col2){
        
    }
}
