import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      
      
/**      
 * Write a description of class spikes here.      
 *       
 * @author (your name)      
 * @version (a version number or a date)      
 */      
public class Spikes extends Up {      
      
    int button, mouseY, mouseX = 0;      
      
    /**      
     * Act - do whatever the spikes wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.      
     */      
    public void act() {      
        follow();      
    }      
      
    /**      
     * sorgt dafuer, dass das objekt nach dem Kauf der Mausposition folgt und sich an der Stelle von spikes, Spikes_platziert setzt.      
     */      
    public void follow() {      
        MouseInfo mouse = Greenfoot.getMouseInfo();      
        if(!Greenfoot.mouseClicked(this)) {      
            if(mouse != null) {      
                mouseX = mouse.getX();      
                mouseY = mouse.getY();      
                if(mouseY > 550) {      
                    mouseY = 670;      
                } else if(mouseY > 360) {      
                    mouseY = 480;      
                } else if(mouseY > 170) {      
                    mouseY = 290;      
                } else {      
                    mouseY = 100;      
                }      
                if(mouseX > 875) {      
                    mouseX = 875;      
                }      
                setLocation(mouseX, mouseY);      
            }      
        } else if(mouse.getX() < 900) {      
            SpikesPlatziert spikesP = new SpikesPlatziert();      
            getWorld().addObject(spikesP, getX(), getY());      
            getWorld().removeObject(this);      
        }      
    }      
}      
