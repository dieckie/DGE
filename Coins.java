import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      
import java.awt.*;

/**
 * Write a description of class coins here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coins extends Actor {

    int coins = 0;

    public Coins() {
        coins = Config.saveCoins;
    }
    
    /**
     * Act - do whatever the coins wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(Greenfoot.isKeyDown("c")) {
            coins++;
            draw();
        }
    }

    /**
     * veraendert die Anzeige bei erhalten eines Coins(C).
     */
    public void draw() {
        // System.out.println("COINS");
        GreenfootImage img = Util.drawCoins(coins);
        img.drawString(coins + "", -3, 37);
        setImage(img);
    }

    public void earnCoins(int coins) {
        this.coins += coins;
        draw();
    }

    public void looseCoins(int coins) {
        this.coins -= coins;
        draw();
    }
}
