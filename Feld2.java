import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Feld2 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Feld2 extends Down {

    Welt1 world;
    int coin;
    Eichhoernchen e;

    /**
     * Act - do whatever the Feld2 wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        world = (Welt1) getWorld();
        coin = world.coins.coins;
        List();
        Kauf();
    }

    /**
     * bestimmt welches Bild das Feld bei welchem status annehmen soll.
     */
    public void List() {
        if(OpenVariable.F2 == 1) {
            setImage("1.png");
        }
        if(OpenVariable.F2 == 2) {
            setImage("2.png");
        }
        if(OpenVariable.F2 == 3) {
            setImage("3.png");
        }
        if(OpenVariable.F2 == 4) {
            setImage("4.png");
        }
        if(OpenVariable.F2 == 5) {
            setImage("5.png");
        }
        if(OpenVariable.F2 == 6) {
            setImage("6.png");
        }
        if(OpenVariable.F2 == 7) {
            setImage("7.png");
        }
        if(OpenVariable.F2 == 8) {
            setImage("8.png");
        }
    }

    /**
     * erstellt Wand bei anklicken und zieht die Muenzen ab (Objekt kann nur gekauft werden, wenn genuegend Muenzen vorhanden sind).
     */
    public void Kauf() {
        if(coin >= 8) {
            if(OpenVariable.F2 == 4 && Greenfoot.mouseClicked(this)) {
                Wand Wand = new Wand();
                getWorld().addObject(Wand, 200, 200);
                world.pause();
                world.coins.lostCoins(8);
            }
        }
        if(coin >= 10) {
            if(OpenVariable.F2 == 2 && Greenfoot.mouseClicked(this) && world.eichhoernchen.getHealth() < 10) {
                world.eichhoernchen.heal(1);
                world.coins.lostCoins(10);
            }
        }
    }
}
