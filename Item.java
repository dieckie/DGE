import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Item extends Actor
{
    String title = "Missing No.";
    String description = "NULL";
    String iconName = "";
    int price = 0;
    boolean placeable = true;
   
    public void act() {
        
    }
    
    public boolean isPlaceable() {
        return placeable;
    }
    
    public abstract Item newInstance();
}