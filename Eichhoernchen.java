import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Eichhoernchen here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Eichhoernchen extends Actor {

    public int SHOT_INTERVAL = 300;
    public int HURT_COOLDOWN = 200;
    long time = 0;
    int health = 10;
    Welt1 w;
    int latestHit = HURT_COOLDOWN;
    /** true is left, false is right */
    boolean direction = false;


    public void act() {
        if(((Welt1) getWorld()).isRunning()) {
            bewegen();
            schiessen();
            gameover();
            latestHit++;
        }
    }

    /**
     * oeffnet den gameover Bildschirm nach dem "tod" (l=0) des Eichhoernchens.
     */
    public void gameover() {
        if(health <= 0) {
            OpenVariable.gameover = true;
        }
        if(OpenVariable.gameover) {
            Greenfoot.setWorld(new Gameover());
            Config.saveWaves = 1;
            Config.saveCoins = 0;
            Config.saveHealth = 10;
            Config.speichern();
        }
    }

    /**
     * setzt das Projektil in die Welt.
     */
    private void schiessen() {
        if(System.currentTimeMillis() - time > SHOT_INTERVAL) {
            if(Greenfoot.isKeyDown("space")) {
                Projektil projektil = new Projektil();
                if(direction) {
                    getWorld().addObject(projektil, getX() - 20, getY() + 17);
                } else {
                    getWorld().addObject(projektil, getX() + 22, getY() + 17);
                }
                projektil.setRotation(90);
                time = System.currentTimeMillis();
            }
        }
    }

    /**
     * Es wird definiert wann sich das Eichhoernchen wie bewegen soll.
     */
    private void bewegen() {
        if(getX() + 28 >= 880) {
            setLocation(879 - 28, getY());
        } else {
            if(Greenfoot.isKeyDown("D")) {
                setImage("eich-rechts.png");
                move(1);
                direction = false;
                if(Greenfoot.isKeyDown("shift")) {
                    move(2);
                }
            }
            if(Greenfoot.isKeyDown("A")) {
                setImage("eichhoernchenlauf1.png");
                move(-1);
                direction = true;
                if(Greenfoot.isKeyDown("shift")) {
                    move(-2);
                }
            }
        }
    }

    public void hurt(int damage) {
        if(latestHit > HURT_COOLDOWN){
            health -= damage;
            latestHit = 0;
        }

    }

    public void heal(int healthGained) {
        health += healthGained;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getShotInterval() {
        return SHOT_INTERVAL;
    }

    public void setShotInterval(int interval) {
        SHOT_INTERVAL = interval;
    }
    // public void initDifficulty(){
    // switch(w.getWellen().getDifficulty()){
    // case 1: SHOT_INTERVAL = 200;
    // break;
    // case 2: SHOT_INTERVAL = 300;
    // break;
    // case 3: SHOT_INTERVAL = 400;
    // break;
    // }
    // }
}