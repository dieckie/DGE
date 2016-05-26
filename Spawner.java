import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Spawner here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spawner extends OpenVariable {

    Enemy enemy;
    int interval;
    int amount;
    int acts = 0;
    int enemysSpawned = 0;

    /**
     * Spawnt mitgegebenen Gegner (mit enemy.newInstance() oder so) mit intervall und anzahl, danach loescht es sich selbst
     * 
     * @param interval
     *            Intervall in act-Methoden-aufrufen.
     */
    public Spawner(Enemy enemy, int interval, int amount) {
        this.enemy = enemy.newInstance();
        this.interval = interval;
        this.amount = amount;
    }

    public Spawner(Enemy enemy, int interval, int amount, int delay) {
        this.enemy = enemy.newInstance();
        this.interval = interval;
        this.amount = amount;
        this.acts = interval - delay;
    }

    /**
     * Act - do whatever the Spawner wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(K==0){
        acts++;
        if(acts > interval) {
            acts = 0;
            getWorld().addObject(enemy.newInstance(), getX(), getY());
            enemysSpawned++;
            if(enemysSpawned >= amount) {
                getWorld().removeObject(this);
            }
        }
    }
    }
}
