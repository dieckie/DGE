 

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)#      
import java.io.*;

/**
 * Write a description of class Welt_1 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */ 
public class Welt1 extends World {
    int x = 0;
    Musik musik;
    Eichhoernchen eichhoernchen;
    Wellen wellen;
    Coins coins;
    int menustate = 0;

    /**
     * Constructor for objects of class Welt_1.
     * 
     */
    public Welt1() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        prepare();
        Class[] paintorder = {Debug.class, Settings.class};
        setPaintOrder(paintorder);
        initDifficulty();
    }

    /**
     * Bereite die Welt fuer den Programmstart vor. Das heisst: Erzeuge die Anfangs- Objekte und fuege sie der Welt hinzu.
     */
    private void prepare() {
        musik = new Musik();
        addObject(musik, 0, 0);
        P1 p1 = new P1();
        addObject(p1, 450, 720);
        P2 p2 = new P2();
        addObject(p2, 450, 620);
        P3 p3 = new P3();
        addObject(p3, 450, 430);
        P4 p4 = new P4();
        addObject(p4, 450, 240);
        eichhoernchen = new Eichhoernchen();
        addObject(eichhoernchen, 450, 92);
        Shop shop = new Shop(); 
        addObject(shop, 1090, 360);
        Greenfoot.setSpeed(60);
        Herzen herzen = new Herzen();
        addObject(herzen, 112, 32);
        herzen.setLocation(200, 30);
        coins = new Coins();
        addObject(coins, 730, 30);
        FertigVorlaeufig fertigVorlaeufig = new FertigVorlaeufig();
        addObject(fertigVorlaeufig, 27, 26);
        Debug debug = new Debug();
        addObject(debug, 190, 75);
        wellen = new Wellen();
        addObject(wellen, 495, 25);
        Config.config(this);
        wellen.initWaves();
        OpenVariable.reset();
        coins.draw(); 
    }

    public Eichhoernchen getEichhoernchen() {
        return eichhoernchen;
    }

    public Wellen getWellen() {
        return wellen;
    }

    public boolean isRunning() {
        return menustate == 0;
    }

    public void pause() {
        menustate = 1;
    }

    public void resume() {
        menustate = 0;
    }


    public void initDifficulty() {
        switch(getWellen().getDifficulty()) {
        case 1:
            getEichhoernchen().setShotInterval(50);
            break;
        case 2:
            getEichhoernchen().setShotInterval(70);
            break;
        case 3:
            getEichhoernchen().setShotInterval(80);
            break;
        }
    }
}
