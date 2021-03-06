import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Spikes_platziert here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spikes extends Item {

    long timeSP = 0;
    /*
     * bestimmt den Zeitabstand, in welchem der Gegener 1 mal Schaden bekommt.
     */
    final int HURT_INTERVAL = 300;
    /*
     * wie oft hat Spike schon getroffen?
     */
    private int hit = 0;
    boolean init = true;
    Welt1 world;
    //TODO durch Act-Methoden ersetzten
    public Spikes() {
        title = "Spikes";
        description = "Wird nach 8 Treffern wieder entfernt";
        iconName = "spikes.png";
        price[0] = 10;
        price[1] = 10;
        price[2] = 20;
        setImage("images/ui/shop/" + iconName);
        unlock[0] = 0;
        unlock[1] = 5;
        unlock[2] = 5;
    }

    /**
     * Die Bedingung sorgt dafuer, dass die Spikes nur schaden machen, wenn man das Spiel fortsetzen will.
     */
    public void act() {
        if(init) {
            init = false;
            world = (Welt1) getWorld();
        }
        if(world.isRunning()) {
            spikesSchaden();
            entfernen();
        }
    }

    /**
     * erzeugt Schaden fuer die Gegner bei Beruehrung.
     */
    private void spikesSchaden() {
        if(System.currentTimeMillis() - timeSP > HURT_INTERVAL) {
            Enemy enemy  = (Enemy) getOneIntersectingObject(Enemy.class);
            if(enemy != null) {
                timeSP = System.currentTimeMillis();
                enemy.verletzten(1);
                hit++;
            }

        }
    }

    /**
     * entfernt die Spikes nach 12 hits.
     */
    private void entfernen() {
        if(hit >= 8) {
            getWorld().removeObject(this);
        }
    }

    public Spikes newInstance() {
        return new Spikes();
    }
}
