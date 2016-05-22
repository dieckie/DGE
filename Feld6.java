import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      
      
/**      
 * Write a description of class Feld6 here.      
 *       
 * @author (your name)      
 * @version (a version number or a date)      
 */      
public class Feld6 extends Down {      
      
    /**      
     * Act - do whatever the Feld6 wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.      
     */      
    public void act() {      
        List();      
    }      
      
    /**      
     * bestimmt welches Bild das Feld bei welchem status annehmen soll.      
     */      
    public void List() {      
        if(F6 == 1) {      
            setImage("1.png");      
        }      
        if(F6 == 2) {      
            setImage("2.png");      
        }      
        if(F6 == 3) {      
            setImage("3.png");      
        }      
        if(F6 == 4) {      
            setImage("4.png");      
        }      
        if(F6 == 5) {      
            setImage("5.png");      
        }      
        if(F6 == 6) {      
            setImage("6.png");      
        }      
        if(F6 == 7) {      
            setImage("7.png");      
        }      
        if(F6 == 8) {      
            setImage("8.png");      
        }      
    }      
}      
