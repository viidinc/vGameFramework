package com.vgf.core.object.additional.deferredcalls;

import com.vgf.core.object.GameObject;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DeferredCaller extends GameObject {

    private final PriorityQueue<DeferredTask> taskQueue = new PriorityQueue<>(
            Comparator.comparingInt(task -> task.callFrame)
    );
    public int currentFrame = 0;

    @Override
    public void tick() {
        super.tick();
        while (!taskQueue.isEmpty() && taskQueue.peek().callFrame <= currentFrame) {

            DeferredTask task = taskQueue.poll();
            System.out.println(task);

            task.call();
        }
        currentFrame++;
    }

    public void addTask(Runnable method, int frameDelay){
        taskQueue.add(new DeferredTask(method, currentFrame + frameDelay));
    }

    private record DeferredTask(Runnable method, int callFrame) {

        public void call() {
                method.run();
            }


        }
}
