import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)     
     
/**     
 * Write a description of class up here.     
 *      
 * @author (your name)     
 * @version (a version number or a date)     
 */     
public class Up extends Shop {     
     
    /**     
     * Act - do whatever the up wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.     
     */     
    public void act() {     
        scroll();     
    }     
     
    /**     
     * Verändert die Variablen für die Bildauswahl der Felder.     
     */     
    public void scroll() {     
        if(Greenfoot.mouseClicked(this)) {     
            K = 1;     
            if(F1 == 1) {     
                F1 = 1;     
            } else {     
                F1--;     
                F2--;     
                F3--;     
                F4--;     
                F5--;     
                F6--;     
            }     
        }     
    }     
}     
