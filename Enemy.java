
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy extends Actor {

    Welt1 world;
    Eichhoernchen eichhoernchen;
    GreenfootSound fatality = new GreenfootSound("Fatality.mp3");
    GreenfootSound kick = new GreenfootSound("kick.mp3");

    int COIN_EARNINGS = 1;
    int HEIGHT = 0, WIDTH = 0;
    int DAMAGE = 0;
    int HEALTH = 5;
    int SPEED = 1;
    int WOUND_SPRITE_DURATION = 200;
    String SPRITE_NAME = "";

    int schaden = 0;
    long lastHurt = 0;
    String direction = "r";


    boolean init = true;
    public void act(){
        if(init){
            init = false;

            world = (Welt1) getWorld();
            eichhoernchen = world.getEichhoernchen();

            COIN_EARNINGS = getCoinEarnings();
            GreenfootImage img = getImage();
            HEIGHT = img.getHeight();
            WIDTH = img.getWidth();

            init();
        }
        if(world.isRunning()){
            collisionDetection();
            movement();
            animate();
        }
    }

    public void init(){ 
    }

    public void collisionDetection(){
        if(getX() < eichhoernchen.getX() + 35 + WIDTH / 2 && getX() > eichhoernchen.getX() - 35 - WIDTH / 2 && getY() > eichhoernchen.getY() - 20 && getY() < eichhoernchen.getY() + 20) {
            schadeEichhoernchen();
        }
    }

    public void movement() {
        move(SPEED);
        int row = (695 - (getY() + HEIGHT / 2 )) / 190;
        if(row % 2 == 0){
            direction = "r";
            if(getX() > 860){
                setRotation(270);
            } else {
                setRotation(0);
            }
        } else if(row == 1) {
            direction = "l";
            if(getX() < 35){
                setRotation(270);
            } else {
                setRotation(180);
            }
        } else if(row == 3){
            if(getX() > 860){
                setRotation(180);
                direction = "l";
            } else if(getX() < 35){
                setRotation(0);
                direction = "r";
            }
        }
    }

    String oldDir = "";
    boolean hurtSprite = false;

    public void animate() {
        if(!oldDir.equals(direction) || (System.currentTimeMillis() - lastHurt < WOUND_SPRITE_DURATION) != hurtSprite){
            oldDir = direction;
            String fileName = SPRITE_NAME  + "_" + direction;
            hurtSprite = System.currentTimeMillis() - lastHurt < WOUND_SPRITE_DURATION;
            if(hurtSprite){
                fileName += "_h";
            }
            setImage(new GreenfootImage("images/enemy/" + fileName + ".png"));
        }
    }

    public void schadeEichhoernchen(){
        eichhoernchen.hurt(DAMAGE);
    }

    /**
     * fuegt der Ratte schaden zu; entscheidet ueber die toene bei den Bedingungen.
     */
    public void verletzten() {
        schaden++;
        lastHurt = System.currentTimeMillis();
        kick.setVolume(15);
        kick.play();
        if(schaden >= HEALTH) {
            died();
        }
    }

    public void died() {
        world.wellen.enemyDied();
        getWorld().removeObject(this);
        world.coins.earnCoins(COIN_EARNINGS);
        fatality.setVolume(Settings.volume);
        fatality.play();
    }

    public Enemy newInstance() {
        return new Ratte();
    }

    public int getCoinEarnings(){
        int coins=0;
        switch(world.getWellen().getDifficulty()){
            case 1: 
            coins = 1;
            break;
            case 2:
            coins = 1;
            break;
            case 3:
            coins = 2;
            break;
        }
        return coins;
    }
}
