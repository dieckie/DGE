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
    
    Eichhörnchen eichhörnchen = null;
    int oldHealth = -1;
    
    public void act() {
        if(eichhörnchen == null){
            eichhörnchen = ((Welt1)getWorld()).getEichhörnchen();
        }
        if(oldHealth != eichhörnchen.getHealth()){
            oldHealth = eichhörnchen.getHealth();
            leben();
        }
    }

    /**
     * verändert die Anzeige bei abzug eines Lebens (l).
     */
    private void leben() {
        setImage("images/Herz/H" + eichhörnchen.getHealth() + ".png");
    }
}
