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
        title = "10 goldene Eicheln";
        iconName = "goldene Eichel.png";
        price[0] = 10;
        price[1] = 10;
        price[2] = 10;
        description = "Richten bei Gegnern doppelten Schaden an";
        placeable = false;
        setImage("images/ui/shop/" + iconName);
        unlock[0] = 12;
        unlock[1] = 15;
        unlock[2] = 15;        
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
