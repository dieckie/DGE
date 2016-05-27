 

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class down here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Down extends Shop {

    /**
     * Act - do whatever the down wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    Welt1 world;
    boolean init = true;

    public void act() {
        if(init) {
            init = false;
            world = (Welt1) getWorld();
        }
        scroll();// Add your action code here.
    }

    /**
     * Veraendert die Variablen fuer die Bildauswahl der Felder.
     */
    public void scroll() {
        if(Greenfoot.mouseClicked(this)) {
            world.pause();
            if(OpenVariable.F6 != Shop.MAX_ITEMS) {
                OpenVariable.F1++;
                OpenVariable.F2++;
                OpenVariable.F3++;
                OpenVariable.F4++;
                OpenVariable.F5++;
                OpenVariable.F6++;
            }
        }
    }
}
