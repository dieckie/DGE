import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class down here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Down extends Shop {

    /**
     * Act - do whatever the down wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        scroll();// Add your action code here.
    }

    /**
     * Veraendert die Variablen fuer die Bildauswahl der Felder.
     */
    public void scroll() {
        if(Greenfoot.mouseClicked(this)) {
            K = 1;
            if(F6 == g) {
                F6 = g;
            } else {
                F1++;
                F2++;
                F3++;
                F4++;
                F5++;
                F6++;
            }
        }
    }
}
