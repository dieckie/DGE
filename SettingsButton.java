
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Settings here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class SettingsButton extends Buttons {

    /**
     * Act - do whatever the Settings wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    Welt1 world;
    boolean init = true;
    
    public void act(){
        super.act();
        if(init) {
            init = false;
            world = (Welt1) getWorld();
        }
        if(world.isRunning() && this != null) {
            getWorld().removeObject(this);
        }
    }

    @Override
    public void action(){
        Settings s = new Settings();
        getWorld().addObject(s, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
    }
}
