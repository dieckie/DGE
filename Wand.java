import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)     
     
/**     
 * Write a description of class Wand here.     
 *      
 * @author (your name)     
 * @version (a version number or a date)     
 */     
public class Wand extends Up {     
     
    int button, mouseY, mouseX = 0;     
     
    /**     
     * Act - do whatever the spikes wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.     
     */     
    public void act() {     
        follow();     
    }     
     
    /**     
     * sorgt dafür, dass das objekt nach dem Kauf der Mausposition folgt und sich an der Stelle von Wand, Wand_platziert setzt.     
     */     
    public void follow() {     
        MouseInfo mouse = Greenfoot.getMouseInfo();     
        if(!Greenfoot.mouseClicked(this)) {     
            if(mouse != null) {     
                mouseX = mouse.getX();     
                mouseY = mouse.getY();     
                setLocation(mouseX, mouseY);     
            }     
        } else {     
            WandPlatziert wandP = new WandPlatziert();     
            getWorld().addObject(wandP, getX(), getY());     
            getWorld().removeObject(this);     
        }     
    }     
}     
