import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Herzen here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Herzen extends OpenVariable {

    /**
     * Act - do whatever the Herzen wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    Eichhoernchen eichhoernchen = null;
    int oldHealth = -1;

    public void act() {
        if(eichhoernchen == null) {
            eichhoernchen = ((Welt1) getWorld()).getEichhoernchen();
        }
        if(oldHealth != eichhoernchen.getHealth()) {
            oldHealth = eichhoernchen.getHealth();
            leben();
        }
    }

    /**
     * veraendert die Anzeige bei abzug eines Lebens (l).
     */
    private void leben() {
        setImage("images/Herz/H" + eichhoernchen.getHealth() + ".png");
    }
}
