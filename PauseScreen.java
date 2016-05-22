import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      
      
/**      
 * Write a description of class pause_screen here.      
 *       
 * @author (your name)      
 * @version (a version number or a date)      
 */      
public class PauseScreen extends FertigVorlaeufig {      
      
    /**      
     * Act - do whatever the pause_screen wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.      
     */      
    public void act() {      
        // Add your action code here.      
        if(K == 0 && this != null) {      
            getWorld().removeObject(this);      
        }      
    }      
}      
