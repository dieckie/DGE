import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Feld1 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Feld1 extends Down {

    int coin;
    boolean _1pressed = false;
    int oldF1 = -1;
    Welt1 world = null;

    /**
     * Act - do whatever the Feld1 wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(world == null) {
            world = (Welt1) getWorld();
        }
        coin = world.coins.coins;
        List();
        Kauf();
    }

    /**
     * bestimmt welches Bild das Feld bei welchem status annehmen soll.
     */
    public void List() {
        if(oldF1 != F1) {
            oldF1 = F1;
            if(F1 >= 1 && F1 <= 8) {
                setImage(F1 + ".png");
            }
        }
    }

    /**
     * erstellt Spikes bei anklicken und zieht die Münzen ab (Objekt kann nur gekauft werden, wenn genügend Münzen vorhanden sind).
     */
    public void Kauf() {
        if( world.coins.coins >= 5) {
            if(F1 == 1 && (Greenfoot.mouseClicked(this))) {
                Spikes spikes = new Spikes();
                getWorld().addObject(spikes, 200, 200);
                K = 1;
                world.coins.lostCoins(5);

            }
            if(Greenfoot.isKeyDown("1")) {
                if(!_1pressed) {
                    _1pressed = true;
                    Spikes spikes = new Spikes();
                    getWorld().addObject(spikes, 200, 200);
                    K = 1;
                    world.coins.lostCoins(5);
                }
            } else {
                _1pressed = false;
            }
        }
        if(coin >= 10) {
            if(F1 == 2 && Greenfoot.mouseClicked(this)&&world.eichhörnchen.getHealth()<10) {               
                world.eichhörnchen.heal(1);
                world.coins.lostCoins(10);
            }
        }
    }
}
