 

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Ratte2 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ratte extends Enemy {

    /*
     * Definiert wie lange das Bild bei einem Treffer geaendert bleibt
     */ 
    final int WOUND_SPRITE_DURATION = 200;
    

    /*
     * ueberprueft ob das Bild bei einem Treffer aktiv ist oder nicht
     */
    boolean hurtSprite = false;
    /*
     * Fuegt die Sounds zu Greenfoot hinzu.
     */
    public GreenfootSound Kick = new GreenfootSound("kick.mp3");
    /*
     * welches Schadensbild soll ausgewaehlt werden?
     */
    private boolean SB = false;
    
    
    public Ratte(){
        setImage("images/enemy/mouse_r.png");
        DAMAGE = 1;
        SPEED = 1;
        HEALTH = 5;
        SPRITE_NAME = "mouse";
    }
    
    /**
     * Act - do whatever the Ratte wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        super.act();
        if(world.isRunning()) {
            laufen();
            animate();
        }
    }
    
    
    @Override
    public void init(){
        
    }

    /**
     * sorgt dafuer, dass die Ratte laeuft und sich an den "Ranken" nach oben bewegt.
     */
    public void laufen() {
        if(getX() <= 858) {
            move(1);
        }
        if(getX() >= 858) {
            setRotation(270);
            if(getY() <= 480) {
                setRotation(180);
                setImage("images/enemy/mouse_l.png");
                SB = true;
            } else {
                move(1);
            }
        }
        if(getX() <= 51 && getY() <= 480) {
            setRotation(270);
            if(getY() <= 290) {
                setRotation(0);
                setImage("images/enemy/mouse_r.png");
                SB = false;
            } else {
                move(1);
            }
        }
        if(getX() >= 858 && getY() <= 290) {
            setRotation(270);
            if(getY() <= 100) {
                setRotation(180);
                setImage("images/enemy/mouse_l.png");
                SB = true;
            } else {
                move(1);
            }
        }
    }

    /**
     * entscheidet ueber die Bildaenderung bei einem Treffer.
     */
    public void animate() {
        if(SB) {
            if(hurtSprite) {
                if(System.currentTimeMillis() - lastHurt > WOUND_SPRITE_DURATION) {
                    setImage("images/enemy/mouse_l.png");
                    hurtSprite = false;
                }
            } else {
                if(System.currentTimeMillis() - lastHurt < WOUND_SPRITE_DURATION) {
                    setImage("images/enemy/mouse_l_h.png");
                    hurtSprite = true;
                }
            }
        }
        if(!SB) {
            if(hurtSprite) {
                if(System.currentTimeMillis() - lastHurt > WOUND_SPRITE_DURATION) {
                    setImage("images/enemy/mouse_r.png");
                    hurtSprite = false;
                }
            } else {
                if(System.currentTimeMillis() - lastHurt < WOUND_SPRITE_DURATION) {
                    setImage("images/enemy/mouse_r_h.png");
                    hurtSprite = true;
                }
            }
        }
    }

 

    @Override
    public Ratte newInstance() {
        return new Ratte();
    }
    @Override
    public int getCoinEarnings(){
        int coins = 1;
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
