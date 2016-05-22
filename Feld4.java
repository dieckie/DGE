import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Feld4 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Feld4 extends Down {

    int oldF4 = -1;
    Welt1 world = null;

    /**
     * Act - do whatever the Feld1 wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(world == null) {
            world = (Welt1) getWorld();
        }
        List();
        Kauf();
    }

    /**
     * bestimmt welches Bild das Feld bei welchem status annehmen soll.
     */
    public void List() {
        if(oldF4 != F4) {
            oldF4 = F4;
            if(F4 >= 1 && F4 <= 8) {
                setImage(F4 + ".png");
            }
        }
    }

    /**
     * erstellt Wand bei anklicken und zieht die Muenzen ab (Objekt kann nur gekauft werden, wenn genuegend Muenzen vorhanden sind).
     */
    public void Kauf() {
        if(C >= 8) {
            if(F4 == 4 && Greenfoot.mouseClicked(this)) {
                Wand Wand = new Wand();
                getWorld().addObject(Wand, 200, 200);
                K = 1;
                world.coins.lostCoins(8);
            }
        }
    }
}
