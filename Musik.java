import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Musik here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Musik extends OpenVariable {

    GreenfootSound bgMusic = new GreenfootSound("Double Dragon II_ The Revenge (Arcade) - (Soundtrack - 15 - Mission 1 Boss).mp3");
    boolean mute = false;
    /**
     * einmaliges Starten der Hintergrundmusik
     */
    boolean playingbg = false;

    /**
     * Act - do whatever the Musik wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
        volumeMusic(10);
        if(!playingbg) {
            startMusic();
            playingbg = true;
        }
        if(gameover) {
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
