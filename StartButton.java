import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class StartButton extends Buttons {

    @Override
    public void action() {
        Greenfoot.setWorld(new Welt1());
    }
}
