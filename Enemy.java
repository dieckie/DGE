import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy extends Actor {

    public GreenfootSound fatality = new GreenfootSound("Fatality.mp3");
    Welt1 world;
   
    public Enemy newInstance() {
        return new Ratte();
    }

    public void died(int earnedCoins) {
        Welt1 world = (Welt1) getWorld();
        world.wellen.enemyDied();
        getWorld().removeObject(this);
        world.coins.earnCoins(getCoinEarnings());
        fatality.setVolume(Settings.volume);
        fatality.play();
    }
      public int getCoinEarnings(){
        
        int earnedCoins=0;
        switch(world.getWellen().getDifficulty()){
            case 1: 
            earnedCoins = 1;
            break;
            case 2:
            earnedCoins = 1;
            break;
            case 3:
            earnedCoins = 2;
            break;
        }
        return earnedCoins;
    }
}
