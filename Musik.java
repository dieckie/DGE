 

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Musik here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Musik extends Actor {

    GreenfootSound bgMusic = new GreenfootSound("Double Dragon II_ The Revenge (Arcade) - (Soundtrack - 15 - Mission 1 Boss).mp3");
    boolean mute = false;
    /**
     * einmaliges Starten der Hintergrundmusik
     */
    boolean playingbg = false;
    
    boolean init = true;
    
    Welt1 world;

    /**
     * Act - do whatever the Musik wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(init) {
            world = (Welt1) getWorld();
            init = false;
        }
        volumeMusic(Settings.volume);
        // Add your action code here.
        if(!playingbg) {
            startMusic();
            playingbg = true;
        }
        if(world.isGameOver()) {
            stopMusic();
        }
    }

    /**
     * startet die Hintergrundmusik.
     */
    public void startMusic() {
        bgMusic.playLoop();
    }

    /**
     * stoppt die Hintergrundmusik.
     */
    public void stopMusic() {
        bgMusic.stop();
    }

    /**
     * setzt die Lautstaerke der Hintergrundmusik.
     */
    public void volumeMusic(int volume) {
        bgMusic.setVolume(volume);
    }
}
