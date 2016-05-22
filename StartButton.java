import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class StartButton extends OpenVariable {

    /**
     * oeffnet bei anklicken oder "Enter" druecken die Welt_1.
     */
    public void act() {
        if(Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Welt1());
        }
    }
}
