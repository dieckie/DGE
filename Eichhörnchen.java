import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)     
     
/**     
 * Write a description of class Eichhörnchen here.     
 *      
 * @author (your name)     
 * @version (a version number or a date)     
 */     
public class Eichhörnchen extends OpenVariable {     
     
    final int SHOT_INTERVAL = 300;     
         
    long time = 0;      
     
    int health = 10;      
     
         
    public void act() {     
        if(((Welt1)getWorld()).isRunning()) {     
            bewegen();     
            schießen();     
     
            gameover();     
            coinceat();     
            Wellen();     
        }     
     
     
    }     
     
    /**     
     * öffnet den gameover Bildschirm nach dem "tod" (l=0) des Eichhörnchens.     
     */     
    public void gameover() {     
        if(health <= 0) {     
            gameover = true;     
        }     
        if(gameover) {     
     
            Greenfoot.setWorld(new Gameover());     
            saveWaves=1;     
            saveCoins=0;     
            saveHealth=10;     
        }     
    }     
     
    /**     
     * man kann mit einem Tastendruck zu Vorführzwecken beliebig viele Coins hinzu fügen.     
     */     
    private void coinceat()     
    {     
        if(Greenfoot.isKeyDown("c")){     
            C++;     
        }     
    }     
     
    /**     
     * setzt das Projektil in die Welt.      
     */     
    private void schießen()     
     
    {     
        if(System.currentTimeMillis() - time > SHOT_INTERVAL) {     
            if(e == 0) {     
                if(Greenfoot.isKeyDown("space")) {     
                    Projektil projektil = new Projektil();     
                    getWorld().addObject(projektil, getX() + 22, getY() + 17);     
                    projektil.setRotation(+90);     
                    time = System.currentTimeMillis();     
                }     
            }     
            if(e == 1) {     
                if(Greenfoot.isKeyDown("space")) {     
                    Projektil projektil = new Projektil();     
                    getWorld().addObject(projektil, getX() - 20, getY() + 17);     
                    projektil.setRotation(+90);     
                    time = System.currentTimeMillis();     
                }     
            }     
        }     
    }     
     
    /**     
     * Es wird definiert wann sich das Eichhörnchen wie bewegen soll.     
     */     
    private void bewegen() {     
        if(getX() + 28 >= 880) {     
            setLocation(879 - 28, getY());     
        } else {     
            if(Greenfoot.isKeyDown("D") && Greenfoot.isKeyDown("shift")) {     
                setImage("eich-rechts.png");     
                move(3);     
                e = 0;     
            } else {     
                if(Greenfoot.isKeyDown("D")) {     
                    setImage("eich-rechts.png");     
                    move(1);     
                    e = 0;     
                }     
            }     
            if(Greenfoot.isKeyDown("A") && Greenfoot.isKeyDown("shift")) {     
                setImage("eichhörnchenlauf1.png");     
                move(-3);     
                e = 1;     
            } else {     
                if(Greenfoot.isKeyDown("A")) {     
                    setImage("eichhörnchenlauf1.png");     
                    move(-1);     
                    e = 1;     
                }     
            }     
        }     
    }     
     
    /**     
     * nächste Welle.     
     */     
    public void Wellen(){     
        if(d == t && s_d == s_t) {     
            W++;     
     
        }     
    }     
         
    public void hurt(int damage){     
        health -= damage;     
    }     
        
    public void heal(int healthGained){     
        health += healthGained;     
    }     
         
    public int getHealth(){     
        return health;     
    }     
         
         
     
     
}     
