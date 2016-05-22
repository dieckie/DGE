import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)     
import java.io.File;     
     
/**     
 * Write a description of class Open_Variable here.     
 *      
 * @author (your name)     
 * @version (a version number or a date)     
 */     
public class OpenVariable extends Actor {     
     
    static String username, password;     
    static int saveCoins, saveHealth, saveWaves;     
    /*     
     * anzahl der Coins.     
     */     
    static int C = 0;     
    /*     
     * macht dass man nur einen weiteren spieler hinzufügen kann     
     */     
    static int x = 0;     
    /*     
     * gibt die projektilposition an     
     */     
    static int e = 0;     
    /**     
     * Gegner(Ratte)     
     */     
    /*     
     * Anzahl der pro Welle zu spawnenden Ratten     
     */     
    static int t = 1;     
    /*     
     * bereits gespawnte Ratten     
     */     
    static int z = 0;     
    static int j = 200;     
    /*     
     * bereits getötete Ratten     
     */     
    static int d = 0;     
    static double gs = 1;     
    static int schadenR = 0;     
    static int wandX = 0;     
    static int wandY = 0;     
    /**     
     * Gegner(Schlange)     
     */     
    /*     
     * Anahl der pro Welle zu spawnenden Schlangen     
     */     
    static int s_t = 0;     
    /*     
     * bereits gespawnte Schlangen     
     */     
    static int s_z = 0;     
    static int s_j = 500;     
    /*     
     * bereits getötete Schlangen     
     */     
    static int s_d = 0;     
    static double s_gs = 1;     
    /*     
     * Leben(Spieler)     
     */     
    static int l = 10;     
    /*     
     * spiel verloren     
     */     
    static boolean gameover = false;     
    /*     
     * spiel gewonnen     
     */     
    static boolean Win = false;     
    /*     
     * Felder Shop Variablen für Bilder     
     */     
    static int F1 = 1;     
    static int F2 = 2;     
    static int F3 = 3;     
    static int F4 = 4;     
    static int F5 = 5;     
    static int F6 = 6;     
    /*     
     * maximale Anzahl an Gegenständen im Shop     
     */     
    static int g = 8;     
    /*     
     * stoppt die Gegner und den Spieler     
     */     
    static int K = 0;     
    /*     
     * objekt aus Shop platzierbar     
     */     
    static int m = 0;     
    /*     
     * nächste Welle     
     */     
    static int W = 1;     
    /*     
     * hält die Gegner an     
     */     
    static boolean wand = false;     
     
    /**     
     * alle Variablen werden bei einem Neustart auf den Startwert zurückgesetzt.     
     */     
    public static void reset() {     
        File f = new File("config.txt");     
        Config c = new Config(f);     
        c.config();     
        // C=0;     
        x = 0;     
        e = 0;     
        t = 1;     
        z = 0;     
        j = 200;     
        d = 0;     
        schadenR = 0;     
        s_t = 0;     
        s_z = 0;     
        s_j = 500;     
        s_d = 0;     
        // l = 10;     
        gameover = false;     
        Win = false;     
        F1 = 1;     
        F2 = 2;     
        F3 = 3;     
        F4 = 4;     
        F5 = 5;     
        F6 = 6;     
        g = 8;     
        K = 0;     
        m = 0;     
        // W = 1;     
        wandX = 0;     
        wandY = 0;     
    }     
}     
