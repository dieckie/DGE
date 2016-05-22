import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)     
     
/**     
 * Write a description of class Feld3 here.     
 *      
 * @author (your name)     
 * @version (a version number or a date)     
 */     
public class Feld3 extends Down {     
     
    Welt1 world = null;     
    int coin;     
     
    /**     
     * Act - do whatever the Feld3 wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.     
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
        if(F3 == 1) {     
            setImage("1.png");     
        }     
        if(F3 == 2) {     
            setImage("2.png");     
        }     
        if(F3 == 3) {     
            setImage("3.png");     
        }     
        if(F3 == 4) {     
            setImage("4.png");     
        }     
        if(F3 == 5) {     
            setImage("5.png");     
        }     
        if(F3 == 6) {     
            setImage("6.png");     
        }     
        if(F3 == 7) {     
            setImage("7.png");     
        }     
        if(F3 == 8) {     
            setImage("8.png");     
        }     
    }     
     
    /**     
     * erstellt Wand bei anklicken und zieht die Münzen ab (Objekt kann nur gekauft werden, wenn genügend Münzen vorhanden sind).     
     */     
    public void Kauf() {     
        if(coin >= 8) {     
            if(F3 == 4 && Greenfoot.mouseClicked(this)) {     
                Wand Wand = new Wand();     
                getWorld().addObject(Wand, 200, 200);     
                K = 1;     
                world.coins.lostCoins(8);     
            }     
        }     
    }     
}     
