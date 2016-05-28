import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Mute here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mute extends Buttons {

    boolean init = true;
    Musik musik;
    Welt1 world;
    int volume1;
    int volume2;

    public void act() {
        super.act();
        if(init) {
            init = false;
            world = (Welt1) getWorld();
            musik = world.musik;
        }
        if(world.isRunning() && this != null) {
            getWorld().removeObject(this);
        }
    }

    @Override
    public void action() {
        mute();
    }

    private void mute() {
        if(!musik.mute) {
            volume1 = Settings.volume;
            volume2 = Settings.clickVolume;
            Settings.volume = 0;
            Settings.clickVolume = 0;
            musik.mute = true;
        } else if(musik.mute) {
            Settings.volume = volume1;
            Settings.clickVolume = volume2;
            musik.mute = false;
        }
        aussehen();
    }

    private void aussehen() {
        if(musik.mute) {
            setImage("unmute.png");
        } else {
            setImage("Mute.png");
        }
    }
}
