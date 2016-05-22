import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class Debug here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Debug extends Actor {

    Welt1 world;

    /**
     * Act - do whatever the Debug wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Da passiert was
        world=(Welt1)getWorld();
        if(Greenfoot.isKeyDown("F3")) {
            greenfoot.MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse != null) {
                GreenfootImage img = new GreenfootImage(200, 50);
                img.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
                img.drawString(String.format("%4d/%3d", mouse.getX(), mouse.getY()), 0, 40);
                setImage(img);
            }
        } else {
            setImage("leer.png");
        }
        if (Greenfoot.isKeyDown("-")){
            world.eichhörnchen.hurt(1);
        }
        if (Greenfoot.isKeyDown("+")&&world.eichhörnchen.getHealth()<10){
            world.eichhörnchen.heal(1);
        }
    }
}
