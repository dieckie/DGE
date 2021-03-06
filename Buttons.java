import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buttons here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Buttons extends Actor {

    GreenfootSound kick = new GreenfootSound("kick.mp3");

    /**
     * Act - do whatever the Buttons wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)) {
            kick.setVolume(Settings.clickVolume);
            kick.play();
            action();
        }
    }

    public abstract void action();
}