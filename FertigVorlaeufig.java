import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Fertig_vorlaeufig here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class FertigVorlaeufig extends Actor {

    boolean isEscPressed = false;
    boolean init = true;
    Welt1 world;
    boolean oldRunning = false;

    /**
     * setzt den Spielverlauf fort.
     */
    public void act() {
        if(init) {
            world = (Welt1) getWorld();
            init = false;
        }
        druecken();
        if(oldRunning != world.isRunning()) {
            repaint();
            oldRunning = world.isRunning();
        }
    }

    public void druecken() {
        if(Greenfoot.isKeyDown("escape")) {
            if(world.isRunning() && !isEscPressed) {
                world.pause();
                PauseScreen pauseScreen = new PauseScreen();
                getWorld().addObject(pauseScreen, 450, 245);
                Mute m = new Mute();
                getWorld().addObject(m, 450, 435);
                SettingsButton s = new SettingsButton();
                getWorld().addObject(s, 450, 625);
                isEscPressed = true;
            } else if(!world.isRunning() && !isEscPressed) {
                world.resume();
                isEscPressed = true;
            }
        } else {
            isEscPressed = false;
        }
        if(Greenfoot.mouseClicked(this) && world.isRunning()) {
            world.pause();
            PauseScreen pauseScreen = new PauseScreen();
            getWorld().addObject(pauseScreen, 450, 245);
            Mute m = new Mute();
            getWorld().addObject(m, 450, 435);
            SettingsButton s = new SettingsButton();
            getWorld().addObject(s, 450, 625);
        } else {
            if(Greenfoot.mouseClicked(this) && !world.isRunning()) {
                world.resume();
            }
        }
    }

    public void repaint() {
        if(world.isRunning()) {
            setImage("images/pause.png");
        } else {
            setImage("images/play.png");
        }
    }
}
