import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and snakeInfo)      

/**
 * Write a description of class Schlange here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Schlange extends Enemy {

    Eichhoernchen eichhoernchen = null;
    Welt1 world;
    /*
     * gibt an wie oft die Schlange getroffen wurde
     */
    int schadenS = 0;
    /*
     * gibt die Zeit wie lange der letze Treffer her ist
     */
    long lastHurtS = 0;
    /*
     * ueberprueft ob das Bild bei einem Treffer aktiv ist oder nicht
     */
    boolean hurtSpriteS = false;
    /*
     * Definiert wie lange das Bild bei einem Treffer geaendert bleibt
     */
    final int WOUND_SPRITE_DURATION_S = 200;
    /*
     * Fuegt die Sounds zu Greenfoot hinzu.
     */
    public GreenfootSound Kick = new GreenfootSound("kick.mp3");
    public GreenfootSound Fatality = new GreenfootSound("Fatality.mp3");
    /*
     * welches Schadensbild soll ausgewaehlt werden?
     */
    private boolean SB = false;
    boolean init = true;
    int earnedCoins;
    /**
     * Act - do whatever the Ratte wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(init) {
            init = false;
            world = ((Welt1) getWorld());
            eichhoernchen = world.getEichhoernchen();
        }
        if(world.isRunning()) {
            if(!OpenVariable.wand) {
                laufen();
                schaden();
                animate();
            }
        }
    }

    /**
     * sorgt dafuer, dass die Schlange laeuft und sich an den "Ranken" nach oben bewegt.
     */
    public void laufen() {
        if(getX() <= 860) {
            move(2);
        }
        if(getX() >= 858) {
            setRotation(270);
            if(getY() <= 480) {
                setRotation(180);
                setImage("snake3.png");
                SB = true;
            } else {
                move(2);
            }
        }
        if(getX() <= 51 && getY() <= 480) {
            setRotation(270);
            if(getY() <= 290) {
                setRotation(0);
                setImage("snake.png");
                SB = false;
            } else {
                move(2);
            }
        }
        if(getX() >= 858 && getY() <= 290) {
            setRotation(270);
            if(getY() <= 100) {
                setRotation(180);
                setImage("snake3.png");
                SB = true;
            } else {
                move(2);
            }
        }
    }

    /**
     * entscheidet ueber die Bildaenderung bei einem Treffer.
     */
    public void animate() {
        if(SB) {
            if(hurtSpriteS) {
                if(System.currentTimeMillis() - lastHurtS > WOUND_SPRITE_DURATION_S) {
                    setImage("images/snake3.png");
                    hurtSpriteS = false;
                }
            } else {
                if(System.currentTimeMillis() - lastHurtS < WOUND_SPRITE_DURATION_S) {
                    setImage("images/snake2_2.png");
                    hurtSpriteS = true;
                }
            }
        }
        if(!SB) {
            if(hurtSpriteS) {
                if(System.currentTimeMillis() - lastHurtS > WOUND_SPRITE_DURATION_S) {
                    setImage("images/snake.png");
                    hurtSpriteS = false;
                }
            } else {
                if(System.currentTimeMillis() - lastHurtS < WOUND_SPRITE_DURATION_S) {
                    setImage("images/snake2.png");
                    hurtSpriteS = true;
                }
            }
        }
    }

    /**
     * erzeugt Schaden am Eichhoernchen.
     */
    public void schaden() {
        if(getX() < eichhoernchen.getX() + 75 && getX() > eichhoernchen.getX() - 75 && getY() == 98) {
            eichhoernchen.hurt(1);
        }
    }

    /**
     * fuegt der Schlange schaden zu; entscheidet ueber die toene bei den Bedingungen.
     */
    public void verletzten() {
        schadenS++;
        lastHurtS = System.currentTimeMillis();
        Kick.setVolume(15);
        Kick.play();
        if(schadenS >= 3) {            
            died(getCoinEarnings());
        }
    }

    public void warten() {
        setLocation(getX(), getY());
    }

    public Schlange newInstance() {
        return new Schlange();
    }
    @Override
    public int getCoinEarnings(){
        switch(world.getWellen().getDifficulty()){
            case 1: 
            earnedCoins = 2;
            break;
            case 2:
            earnedCoins = 2;
            break;
            case 3:
            earnedCoins = 3;
            break;
        }
        return earnedCoins;
    }
}
