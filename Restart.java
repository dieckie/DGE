import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Restart here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Restart extends Buttons {

    @Override
    public void action() {
        Greenfoot.setWorld(new Welt1());
    }
}