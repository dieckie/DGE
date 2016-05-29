import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Item extends Actor {

    String title = "Missing No.";
    String description = "NULL";
    String iconName = "";
    int[] price = {0,0,0};
    boolean placeable = true;
    int[] unlock = {0,0,0};

    public void act() {
        
    }

    public boolean isPlaceable() {
        return placeable;
    }

    public boolean isBuyable(Welt1 world) {
        return true;
    }

    public abstract Item newInstance();
}
