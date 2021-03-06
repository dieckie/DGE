import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class pause_screen here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class PauseScreen extends Buttons {

    boolean init = true;
    Welt1 world;

    public void act() {
        super.act();
        if(init) {
            world = (Welt1) getWorld();
        }
        if(world.isRunning() && this != null) {
            getWorld().removeObject(this);
        }
    }

    @Override
    public void action() {
        world.pause();
    }
}
