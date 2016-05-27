import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy extends Actor {

    //TODO Weiter machen!!
    
    GreenfootSound fatality = new GreenfootSound("Fatality.mp3");
    Welt1 world;
    boolean init = true;
    
    int COIN_EARNINGS = 1;
    int HEIGHT = 0, WIDTH = 0;
    int DAMAGE = 0;
    
    public void act(){
        if(init){
            init = false;
            world = (Welt1) getWorld();
            COIN_EARNINGS = getCoinEarnings();
            GreenfootImage img = getImage();
            HEIGHT = img.getHeight();
            WIDTH = img.getWidth();
        }
    }
   
    public Enemy newInstance() {
        return new Ratte();
    }

    public void died(int earnedCoins) {
        world.wellen.enemyDied();
        getWorld().removeObject(this);
        world.coins.earnCoins(COIN_EARNINGS);
        fatality.setVolume(Settings.volume);
        fatality.play();
    }
    public int getCoinEarnings(){
        int coins=0;
        switch(world.getWellen().getDifficulty()){
            case 1: 
            coins = 1;
            break;
            case 2:
            coins = 1;
            break;
            case 3:
            coins = 2;
            break;
        }
        return coins;
    }
}
