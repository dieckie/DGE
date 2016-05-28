import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Herz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Herz extends Item {   
    
    public Herz(){
        title = "Herz";
        description = "Fuellt ein halbes Herz wieder auf";
        iconName = "herz.png";
        price = 10;
        placeable = false;
        setImage("images/ui/shop/" + iconName);
    }
    
    public void act() {
        Welt1 world = (Welt1) getWorld();
        world.getEichhoernchen().heal(1);
        world.removeObject(this);
    }
    
    public Herz newInstance() {
        return new Herz();
    }
}
