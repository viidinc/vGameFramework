package com.vgf.core.object.additional;

import com.raylib.Raylib;
import com.vgf.core.object.GameObject;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import static com.raylib.Raylib.rlVertex2f;

public class Particles2D extends GameObject {

    private final ArrayList<Particle> particles = new ArrayList<>();
    private static final Random rand = new Random();

    private static final int MAX_BATCH_SIZE = 512;

    private float getRand(){
        float r = rand.nextFloat()-0.5f;
        boolean i = r>0;
        r = r*r;
        if (i){r*=-1;}
        return r*30.0f;
    }

    private class Particle{
        //This is quad particle

        //Using primitives to avoid marshalling
        float x = 0;
        float y = 0;

        //Additive to position
         float width = 1.0f;
         float height = 1.0f;

        float xVel = getRand();
        float yVel = getRand();

        Particle(float x, float y){
            this.x = x;
            this.y = y;
        }

        void draw(){

/*
            rlVertex2f(x,y);
            rlVertex2f(x+width,y);
            rlVertex2f(x + width,y+height);
            rlVertex2f(x , y + height);
*/
            rlVertex2f(x,y+height);
            rlVertex2f(x,y);
            rlVertex2f(x + width,y);

            rlVertex2f(x + width,y);
            rlVertex2f(x + width,y+height);
            rlVertex2f(x , y + height);


        }

        void tick(){
            yVel+=0.5f;
            xVel*=1.1f+Math.sin(System.currentTimeMillis()*0.01);
            y+=yVel;
            x+=xVel;
        }
    }



    @Override
    public void tick() {
        super.tick();
        particles.removeIf((p) -> p.y>1000.0f);
        if (Raylib.isMouseButtonPressed(Raylib.MouseButton.MOUSE_BUTTON_LEFT)){
            Raylib.rlDisableBackfaceCulling();
            for (int i = 0; i < 1000; i++){
                Particle part = new Particle(Raylib.getMouseX(),Raylib.getMouseY());
                particles.add(part);
            }
        }
        for (Particle particle : particles){
            particle.tick();
        }
    }

    @Override
    public void draw() {
        super.draw();
        final int mode = 4;
        Raylib.rlBegin(mode);

        Raylib.rlColor3f((float) Math.sin(System.currentTimeMillis()*0.001),0.0f, (float) Math.cos(System.currentTimeMillis()*0.001));

        int iterCounter = 0;
        for (Particle particle : particles){
            if (iterCounter>=MAX_BATCH_SIZE){
                Raylib.rlEnd();
                Raylib.rlBegin(mode);
                iterCounter = 0;
            }
            particle.draw();
            iterCounter++;
        }
        System.out.println(particles.size());
        Raylib.rlEnd();
    }
}
