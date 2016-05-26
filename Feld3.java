import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Feld3 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Feld3 extends Down {

    Welt1 world = null;

    /**
     * Act - do whatever the Feld3 wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        world = (Welt1) getWorld();
        List();
        Kauf();
    }

    /**
     * bestimmt welches Bild das Feld bei welchem status annehmen soll.
     */
    public void List() {
        if(OpenVariable.F3 == 1) {
            setImage("1.png");
        }
        if(OpenVariable.F3 == 2) {
            setImage("2.png");
        }
        if(OpenVariable.F3 == 3) {
            setImage("3.png");
        }
        if(OpenVariable.F3 == 4) {
            setImage("4.png");
        }
        if(OpenVariable.F3 == 5) {
            setImage("5.png");
        }
        if(OpenVariable.F3 == 6) {
            setImage("6.png");
        }
        if(OpenVariable.F3 == 7) {
            setImage("7.png");
        }
        if(OpenVariable.F3 == 8) {
            setImage("8.png");
        }
    }

    /**
     * erstellt Wand bei anklicken und zieht die Muenzen ab (Objekt kann nur gekauft werden, wenn genuegend Muenzen vorhanden sind).
     */
    public void Kauf() {
        if(world.coins.coins >= 8) {
            if(OpenVariable.F3 == 4 && Greenfoot.mouseClicked(this)) {
                Wand Wand = new Wand();
                getWorld().addObject(Wand, 200, 200);
                world.pause();
                world.coins.lostCoins(8);
            }
        }
    }
}
