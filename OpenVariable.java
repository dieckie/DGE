 

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      
import java.io.File;

/**
 * Write a description of class Open_Variable here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class OpenVariable extends Actor {
 
    /*
     * spiel verloren
     */
    static boolean gameover = false;
    /*
     * spiel gewonnen
     */
    static boolean Win = false;

    /**
     * alle Variablen werden bei einem Neustart auf den Startwert zurueckgesetzt.
     */
    public static void reset() {
        gameover = false;
        Win = false;
    }
}
