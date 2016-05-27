
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and snakeInfo)      
/**
 * Write a description of class Schlange here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Schlange extends Enemy {
    
    boolean hurtSprite = false;
    final int WOUND_SPRITE_DURATION = 200;
    private boolean SB = false;

    public Schlange(){
        setImage("images/enemy/snake_r.png");
        DAMAGE = 1;
        SPEED = 2;
        HEALTH = 3;
        SPRITE_NAME = "snake";
    }

    @Override
    public void init() {
    }

    public void act() {
        super.act();
        if(world.isRunning()) {
            laufen2();
            animate();
        }
    }

    /**
     * sorgt dafuer, dass die Schlange laeuft und sich an den "Ranken" nach oben bewegt.
     */
    public void laufen() {
        move(2);

        if(getX() >= 858) {
            setRotation(270);
            if(getY() <= 480) {
                setRotation(180);
                setImage("images/enemy/snake_l.png");
                SB = true;
            }
        }
        if(getX() <= 51 && getY() <= 480) {
            setRotation(270);
            if(getY() <= 290) {
                setRotation(0);
                setImage("images/enemy/snake_r.png");
                SB = false;
            }
        }
        if(getX() >= 858 && getY() <= 290) {
            setRotation(270);
            if(getY() <= 100) {
                setRotation(180);
                setImage("images/enemy/snake_l.png");
                SB = true;
            }
        }
    }
    
        public void laufen2() {
        move(2);
        int row = (695 - (getY() + HEIGHT / 2 )) / 190;
        System.out.println();
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
        // if(getX() >= 858) {
            // setRotation(270);
            // if(getY() <= 480) {
                // setRotation(180);
                // setImage("images/enemy/snake_l.png");
                // SB = true;
            // }
        // }
        // if(getX() <= 51 && getY() <= 480) {
            // setRotation(270);
            // if(getY() <= 290) {
                // setRotation(0);
                // setImage("images/enemy/snake_r.png");
                // SB = false;
            // }
        // }
        // if(getX() >= 858 && getY() <= 290) {
            // setRotation(270);
            // if(getY() <= 100) {
                // setRotation(180);
                // setImage("images/enemy/snake_l.png");
                // SB = true;
            // }
        // }
    }

    /**
     * entscheidet ueber die Bildaenderung bei einem Treffer.
     */
    public void animate() {
        if(SB) {
            if(hurtSprite) {
                if(System.currentTimeMillis() - lastHurt > WOUND_SPRITE_DURATION) {
                    setImage("images/enemy/snake_l.png");
                    hurtSprite = false;
                }
            } else {
                if(System.currentTimeMillis() - lastHurt < WOUND_SPRITE_DURATION) {
                    setImage("images/enemy/snake_l_h.png");
                    hurtSprite = true;
                }
            }
        }
        if(!SB) {
            if(hurtSprite) {
                if(System.currentTimeMillis() - lastHurt > WOUND_SPRITE_DURATION) {
                    setImage("images/enemy/snake_r.png");
                    hurtSprite = false;
                }
            } else {
                if(System.currentTimeMillis() - lastHurt < WOUND_SPRITE_DURATION) {
                    setImage("images/enemy/snake_r_h.png");
                    hurtSprite = true;
                }
            }
        }
    }

    public Schlange newInstance() {
        return new Schlange();
    }

    @Override
    public int getCoinEarnings(){
        int coinEarnings = 0;
        switch(world.getWellen().getDifficulty()){
            case 1: 
            coinEarnings = 2;
            break;
            case 2:
            coinEarnings = 2;
            break;
            case 3:
            coinEarnings = 3;
            break;
        }
        return coinEarnings;
    }
}
