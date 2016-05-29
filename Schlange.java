import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and snakeInfo)      

/**
 * Write a description of class Schlange here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Schlange extends Enemy {
    public Schlange() {
        setImage("images/entity/snake_r.png");
        DAMAGE = 1;
        SPEED = 2;
        SPRITE_NAME = "snake";
        WOUND_SPRITE_DURATION = 200;
        switch(Config.difficulty) {
            case 1:
            HEALTH = 4;
            break;
            case 2:
            HEALTH = 3;
            break;
            case 3:
            HEALTH = 3;
            break;
        }
    }

    public Schlange newInstance() {
        return new Schlange();
    }

    @Override
    public int getCoinEarnings(int difficulty) {
        switch(difficulty) {
            case 1:
            return 2;
            case 2:
            return 3;
            case 3:
            return 4;
        }
        return 0;
    }
}
