import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Schlangen_spawner here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class SchlangenSpawner extends OpenVariable {

    public Schlange schlange;public Eichhö
    rnchen eichhörnchen;
    /*
     * spawn-Frequenz
     */
    int S_frequency = 230;
    /*
     * spawn-Interval
     */
    int S_i = 150;

    /**
     * Act - do whatever the Gegner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public SchlangenSpawner(Eichhörnchen eh) {
        eichhörnchen = eh;
    }

    /**
     * das "spawn-Interval" wird durch eine Verzögerung(erzeugt durch S_i) reguliert.
     */
    public void act() {
        S_i++;
        if(S_i >= S_frequency) {
            S_i = 0;
            spawnen();
        }
    }

    /**
     * spawnt neue Schlange.
     */
    public void spawnen() {
        if(s_z < s_t) {
            Schlange s = new Schlange();
            getWorld().addObject(s, 57, 670);
            s_z++;
        }
    }
}
