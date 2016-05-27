 

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.awt.image.*;

/**
 * Write a description of class Setting here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Settings extends FertigVorlaeufig {

    /**
     * Act - do whatever the Setting wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean following = false;
    int tonX = 0, oldTonX = -1;
    int clickX = 0, oldClickX = -1;
    static int volume = 10;
    static int clickVolume = 10;
    GreenfootSound kick = new GreenfootSound("kick.mp3");
    public Settings() {
        tonX = volume * 6;
        clickX = clickVolume * 6;
        repaint();
    }

    public void act() {
        greenfoot.MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null) {
            if(mouse.getButton() == 1) {
                if(mouse.getY() > 240 && mouse.getY() < 270) {
                    if(mouse.getX() > 345 && mouse.getX() < 945) {
                        tonX = mouse.getX() - 345;
                    }
                } else if(mouse.getY() > 350 && mouse.getY() < 390) {
                    if(mouse.getX() > 345 && mouse.getX() < 945) {
                        clickX = mouse.getX() - 345;
                    }
                } else if(mouse.getY() > 460 && mouse.getY() < 560) {
                    if(mouse.getX() > 500 && mouse.getX() < 800) {
                        getWorld().removeObject(this);
                        kick.setVolume(Settings.clickVolume);
                        kick.play();
                    }
                }
            }
        }
        if(tonX != oldTonX || clickX != oldClickX) {
            volume = tonX / 6;
            clickVolume = clickX / 6;
            repaint();
        }
    }

    public void repaint() {
        oldTonX = tonX;
        oldClickX = clickX;
        GreenfootImage img = new GreenfootImage("images/ui/settings/settings.png");
        img.drawImage(new GreenfootImage("images/ui/settings/regler.png"), tonX + 135, 175);
        img.drawImage(new GreenfootImage("images/ui/settings/regler.png"), clickX + 135, 292);
        setImage(img);
    }
}
