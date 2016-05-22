import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      
      
/**      
 * Write a description of class Gameover here.      
 *       
 * @author (your name)      
 * @version (a version number or a date)      
 */      
public class Gameover extends World {      
      
    /**      
     * Constructor for objects of class Gameover.      
     *       
     */      
    public Gameover() {      
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.      
        super(1280, 720, 1);      
        prepare();      
    }      
      
    /**      
     * Bereite die Welt fuer den Programmstart vor. Das heisst: Erzeuge die Anfangs- Objekte und fuege sie der Welt hinzu.      
     */      
    private void prepare() {      
        Restart restart = new Restart();      
        addObject(restart, 640, 220);      
        Exit exit = new Exit();      
        addObject(exit, 640, 380);      
    }      
}      
