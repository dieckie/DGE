 

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
    /*
     * Felder Shop Variablen fuer Bilder
     */
    static int F1 = 1;
    static int F2 = 2;
    static int F3 = 3;
    static int F4 = 4;
    static int F5 = 5;
    static int F6 = 6;

    /**
     * alle Variablen werden bei einem Neustart auf den Startwert zurueckgesetzt.
     */
    public static void reset() {
        gameover = false;
        Win = false;
        F1 = 1;
        F2 = 2;
        F3 = 3;
        F4 = 4;
        F5 = 5;
        F6 = 6;
    }
}
