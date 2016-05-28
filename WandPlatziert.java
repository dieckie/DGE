 

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Wand_platziert here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class WandPlatziert extends Wand {

    private int time = 0;
    Actor ratte;
    Actor schlange;
    Welt1 world;
    boolean init = true;

    /**
     * Act - do whatever the Wand_platziert wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(init) {
            world = (Welt1) getWorld();
        }
        anhalten();
    }

    /**
     * haelt die Gegner bei Beruehrung mit der Wand an; entfernt die Wand nach einer Zeit.
     */
    private void anhalten() {
        ratte = getOneIntersectingObject(Ratte.class);
        schlange = getOneIntersectingObject(Schlange.class);
        if(world.isRunning()) {
            time++;
            if(time <= 1500) {
                if(ratte != null || (schlange != null)) {
                    if(ratte != null) {
                        //((Ratte) getOneIntersectingObject(Ratte.class)).warten();
                    } else {
                        if(schlange != null) {
                            //((Schlange) getOneIntersectingObject(Schlange.class)).warten();
                        }
                    }
                }
            } else {
                getWorld().removeObject(this);
            }
        }
    }
}
