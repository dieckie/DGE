import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.awt.image.*;

/**
 * Write a description of class Setting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Settings extends FertigVorlaeufig
{
    /**
     * Act - do whatever the Setting wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        int width = getWorld().getWidth();
        int height = getWorld().getHeight();
        int cellsize = getWorld().getCellSize();
        BufferedImage off_Image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = off_Image.createGraphics();
        GreenfootImage img = new GreenfootImage(width * cellsize, height * cellsize);
        img.drawLine(0,0,1000,1000);
        setImage(img);
    }    
}
