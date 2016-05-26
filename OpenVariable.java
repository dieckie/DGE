import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      
import java.io.File;

/**
 * Write a description of class Open_Variable here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class OpenVariable extends Actor {

    //static String username, password;
    //static int saveCoins, saveHealth, saveWaves;
    /*
     * macht dass man nur einen weiteren spieler hinzufuegen kann
     */
    static int x = 0;
    static int schadenR = 0;
    static int wandX = 0;
    static int wandY = 0;
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
    /*
     * stoppt die Gegner und den Spieler
     */
    static int K = 0;
    /*
     * objekt aus Shop platzierbar
     */
    static int m = 0;
    /*
     * haelt die Gegner an
     */
    static boolean wand = false;

    /**
     * alle Variablen werden bei einem Neustart auf den Startwert zurueckgesetzt.
     */
    public static void reset() {
        x = 0;
        schadenR = 0;
        gameover = false;
        Win = false;
        F1 = 1;
        F2 = 2;
        F3 = 3;
        F4 = 4;
        F5 = 5;
        F6 = 6;
        K = 0;
        m = 0;
        wandX = 0;
        wandY = 0;
    }
}
