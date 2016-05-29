import greenfoot.*;
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Projektil here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Projektil extends Actor {

    int damage = 1;
    
    public Projektil(boolean golden) {
        if(golden) {
            damage = 2;
            setImage("images/goldene Eichel.png");
        } else {
            damage = 1;
            setImage("images/eichel.png");
        }
    }
    
    /**
     * Act - do whatever the Projektil wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        setLocation(getX(), getY() + 4);
        collisionDetection();
    }

    /**
     * entfernt die Eichel bei Beruehrung mit Gegner
     */
    private void collisionDetection() {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if(enemy != null) {
            enemy.verletzten(damage);
            getWorld().removeObject(this);
        }
        if(getWorld() != null && getY() > getWorld().getHeight() - 4) {
            getWorld().removeObject(this);
        }
    }
}
