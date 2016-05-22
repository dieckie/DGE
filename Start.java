import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      
import java.io.*;      
      
/**      
 * Write a description of class Welle here.      
 *       
 * @author (your name)      
 * @version (a version number or a date)      
 */      
public class Start extends World {      
      
    /**      
     * Constructor for objects of class Welle.      
     *       
     */      
    public Start() {      
        super(1280, 720, 1);      
        prepare();      
    }      
      
    private void prepare() {      
        StartButton startbutton = new StartButton();      
        addObject(startbutton, 660, 617);      
        Title title = new Title();      
        addObject(title, 690, 211);      
        title.setLocation(681, 208);      
        Greenfoot.start();      
    }      
}      
