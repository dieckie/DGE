import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class up here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Up extends Shop {

    /**
     * Act - do whatever the up wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        scroll();
    }

    /**
     * Veraendert die Variablen fuer die Bildauswahl der felder.
     */
    public void scroll() {
        if(Greenfoot.mouseClicked(this)) {
            if(OpenVariable.F1 != 1) {
                OpenVariable.F1--;
                OpenVariable.F2--;
                OpenVariable.F3--;
                OpenVariable.F4--;
                OpenVariable.F5--;
                OpenVariable.F6--;
            }
        }
    }
}
