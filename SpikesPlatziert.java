import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Spikes_platziert here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class SpikesPlatziert extends Spikes {

    long timeSP = 0;
    /*
     * bestimmt den Zeitabstand, in welchem der Gegener 1 mal Schaden bekommt.
     */
    final int HURT_INTERVAL = 300;
    /*
     * wie oft hat Spike schon getroffen?
     */
    private int hit = 0;

    /**
     * Die Bedingung sorgt dafuer, dass die Spikes nur schaden machen, wenn man das Spiel fortsetzen will.
     */
    public void act() {
        if(K == 0) {
            spikesSchaden();
            entfernen();
        }
    }

    /**
     * erzeugt Schaden fuer die Gegner bei Beruehrung.
     */
    private void spikesSchaden() {
        if(System.currentTimeMillis() - timeSP > HURT_INTERVAL) {
            if(getOneIntersectingObject(Ratte.class) != null || (getOneIntersectingObject(Schlange.class) != null)) {
                if(getOneIntersectingObject(Ratte.class) != null) {
                    ((Ratte) getOneIntersectingObject(Ratte.class)).verletzten();
                    timeSP = System.currentTimeMillis();
                    hit++;
                } else {
                    if(getOneIntersectingObject(Schlange.class) != null) {
                        ((Schlange) getOneIntersectingObject(Schlange.class)).verletzten();
                        timeSP = System.currentTimeMillis();
                        hit++;
                    }
                }
            }
        }
    }

    /**
     * entfernt die Spikes nach 12 hits.
     */
    private void entfernen() {
        if(hit >= 12) {
            getWorld().removeObject(this);
        }
    }
}
