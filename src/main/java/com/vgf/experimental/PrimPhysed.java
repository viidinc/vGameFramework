package com.vgf.experimental;

public interface PrimPhysed extends Positioned{
    //Change 5.0f to collider radius
    default float getCollRadius(){return 5.0f;}
    default void onHit(PrimPhysed hit){}
    default void physInit(PrimPhysSolver solver){};
}
