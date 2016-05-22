import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mute here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mute extends FertigVorläufig {

    boolean init = true;
    Musik musik;

    /**
     * Act - do whatever the Mute wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(init) {
            init = false;
            musik = ((Welt1) getWorld()).musik;
        }
        // Add your action code here.
        if(K == 0 && this != null) {
            getWorld().removeObject(this);
        }
        mute();
    }

    private void mute() {
        if(Greenfoot.mouseClicked(this)) {
            if(!musik.mute) {
                musik.stopMusic();
                musik.mute = true;
            } else if(musik.mute) {
                musik.startMusic();
                musik.mute = false;
            }
            aussehen();
        }
    }

    private void aussehen() {
        if(musik.mute) {
            setImage("unmute.png");
        } else {
            setImage("Mute.png");
        }
    }
}
