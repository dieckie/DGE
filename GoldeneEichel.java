import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoldeneEichel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldeneEichel extends Item
{
    public GoldeneEichel() {
        title = "Goldene Eichel";
        iconName = "goldene Eichel.png";
        price = 10;
        description = "10 goldene Eicheln. Richten bei Gegnern höheren Schaden an";
        placeable = false;
        setImage("images/ui/shop/" + iconName);
    }
    
    public void act() {
        Welt1 world = (Welt1) getWorld();
        world.getEichhoernchen().addGoldeneEicheln(10);
        world.removeObject(this);
    }
    
    public GoldeneEichel newInstance() {
        return new GoldeneEichel();
    }
}
