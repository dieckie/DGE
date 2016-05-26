import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy extends Actor {

    public GreenfootSound fatality = new GreenfootSound("Fatality.mp3");

    public Enemy newInstance() {
        return new Ratte();
    }

    public void died() {
        Welt1 world = (Welt1) getWorld();
        world.wellen.enemyDied();
        getWorld().removeObject(this);
        world.coins.earnCoins(1);
        fatality.setVolume(Settings.volume);
        fatality.play();
    }
}
