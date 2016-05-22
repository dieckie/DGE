import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      
      
/**      
 * Write a description of class Fertig_vorlaeufig here.      
 *       
 * @author (your name)      
 * @version (a version number or a date)      
 */      
public class FertigVorlaeufig extends Shop {      
      
    boolean isEscPressed = false;      
      
    /**      
     * setzt den Spielverlauf fort.      
     */      
    public void act() {      
        druecken();      
        druecken2();      
      
    }      
      
    public void druecken(){      
        if(Greenfoot.isKeyDown("escape")) {      
            if(K==0 && !isEscPressed){      
                K=1;      
                PauseScreen pauseScreen = new PauseScreen();      
                getWorld().addObject(pauseScreen,450,245);                 
                Mute m = new Mute();      
                getWorld().addObject(m,450,435);      
                isEscPressed=true;      
      
            }else if( K==1 && !isEscPressed) {      
                K=0;                     
                isEscPressed=true;      
            }      
        }else{      
            isEscPressed=false;      
        }      
        if(Greenfoot.mouseClicked(this) && K==0) {      
            K=1;      
            PauseScreen pauseScreen = new PauseScreen();      
            getWorld().addObject(pauseScreen,450,245);                 
            Mute m = new Mute();      
            getWorld().addObject(m,450,435);      
        }else{      
            if(Greenfoot.mouseClicked(this) && K==1) {      
                K=0;      
      
            }      
        }      
      
    }      
      
    public void druecken2(){      
        if(K==0) {      
            setImage("images/pause.png");      
        }      
        if(K==1) {      
            setImage("images/play.png");      
        }      
    }      
}      
