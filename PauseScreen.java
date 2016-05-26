import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class pause_screen here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class PauseScreen extends FertigVorlaeufig {

    boolean init = true;
    Welt1 world;
    
    public void act() {
        if(init){
            world = (Welt1) getWorld();
        }
        if(Greenfoot.mouseClicked(this)) {
           world.pause();
        }
        if(world.isRunning() && this != null) {
            getWorld().removeObject(this);
        }
    }
}
