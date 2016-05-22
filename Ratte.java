import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ratte2 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ratte extends Enemy {

    /*
     * Definiert wie lange das Bild bei einem Treffer geändert bleibt
     */
    final int WOUND_SPRITE_DURATION = 200;
    final int COIN_EARNING = 1;Eichhö
    rnchen eichhörnchen;
    Welt1 world;
    /*
     * gibt an wie oft die Schlange getroffen wurde
     */
    int schaden = 0;
    /*
     * gibt die Zeit wie lange der letze Treffer her ist
     */
    long lastHurt = 0;
    /*
     * überprüft ob das Bild bei einem Treffer aktiv ist oder nicht
     */
    boolean hurtSprite = false;
    /*
     * Fügt die Sounds zu Greenfoot hinzu.
     */
    public GreenfootSound Kick = new GreenfootSound("kick.mp3");
    /*
     * welches Schadensbild soll ausgewählt werden?
     */
    private boolean SB = false;
    private int x, y, w = 0;
    boolean init = true;

    /**
     * Act - do whatever the Ratte wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(init){
            init = false;
            world = ((Welt1)getWorld());
            eichhörnchen = world.getEichhörnchen();
        }
        if(world.isRunning()){
            laufen();
            schaden();
            animate();
        }
    }

    /**
     * sorgt dafür, dass die Ratte läuft und sich an den "Ranken" nach oben bewegt.
     */
    public void laufen() {
        if(getX() <= 858) {
            move(1);
        }
        if(getX() >= 858) {
            setRotation(270);
            if(getY() <= 480) {
                setRotation(180);
                setImage("mouse3.png");
                SB = true;
            } else {
                move(1);
            }
        }
        if(getX() <= 51 && getY() <= 480) {
            setRotation(270);
            if(getY() <= 290) {
                setRotation(0);
                setImage("mouse.png");
                SB = false;
            } else {
                move(1);
            }
        }
        if(getX() >= 858 && getY() <= 290) {
            setRotation(270);
            if(getY() <= 100) {
                setRotation(180);
                setImage("mouse3.png");
                SB = true;
            } else {
                move(1);
            }
        }
    }

    /**
     * entscheidet über die Bildänderung bei einem Treffer.
     */
    public void animate() {
        if(SB) {
            if(hurtSprite) {
                if(System.currentTimeMillis() - lastHurt > WOUND_SPRITE_DURATION) {
                    setImage("images/mouse3.png");
                    hurtSprite = false;
                }
            } else {
                if(System.currentTimeMillis() - lastHurt < WOUND_SPRITE_DURATION) {
                    setImage("images/mouse2_2.png");
                    hurtSprite = true;
                }
            }
        }
        if(!SB) {
            if(hurtSprite) {
                if(System.currentTimeMillis() - lastHurt > WOUND_SPRITE_DURATION) {
                    setImage("images/mouse.png");
                    hurtSprite = false;
                }
            } else {
                if(System.currentTimeMillis() - lastHurt < WOUND_SPRITE_DURATION) {
                    setImage("images/mouse2.png");
                    hurtSprite = true;
                }
            }
        }
    }

    /**
     * erzeugt Schaden am Eichhörnchen.
     */
    public void schaden()
    {
        if (getX()== eichhörnchen.getX() && getY() == 100)
        {
            eichhörnchen.hurt(1);

        }
    }

    /**
     * fügt der Ratte schaden zu; entscheidet über die töne bei den Bedingungen.
     */
    public void verletzten() {
        schaden++;
        lastHurt = System.currentTimeMillis();
        Kick.setVolume(15);
        Kick.play();
        if(schaden >= 5) {
            died();
        }
    }

    public void warten() {
        x = ((WandPlatziert) getOneIntersectingObject(WandPlatziert.class)).getX();
        y = ((WandPlatziert) getOneIntersectingObject(WandPlatziert.class)).getY();
        setLocation(x, y);
    }

    @Override
    public Ratte newInstance() {
        return new Ratte();
    }
}
