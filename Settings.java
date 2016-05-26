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
    int tonX = 0;
    int oldTonX = -1;
    static int volume = 10;

    public Settings() {
        tonX = volume * 6;
        repaint();
    }

    public void act() {
        greenfoot.MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null) {
            if(mouse.getButton() == 1) {
                if(mouse.getY() > 240 && mouse.getY() < 270) {
                    if(mouse.getX() > 345 && mouse.getX() < 945) {
                        tonX = mouse.getX() - 345;
                        // System.out.println(tonX);
                    }
                } else if(mouse.getY() > 460 && mouse.getY() < 560) {
                    if(mouse.getX() > 500 && mouse.getX() < 800) {
                        getWorld().removeObject(this);
                    }
                }
            }
        }
        if(tonX != oldTonX) {
            volume = tonX / 6;
            repaint();
        }
    }

    public void repaint() {
        oldTonX = tonX;
        GreenfootImage img = new GreenfootImage("images/ui/settings/settings.png");
        img.drawImage(new GreenfootImage("images/ui/settings/regler.png"), tonX + 135, 175);
        setImage(img);
    }
}
