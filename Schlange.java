import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and snakeInfo)      

/**
 * Write a description of class Schlange here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Schlange extends Enemy {

    public Schlange() {
        setImage("images/enemy/snake_r.png");
        DAMAGE = 1;
        SPEED = 2;
        HEALTH = 3;
        SPRITE_NAME = "snake";
        WOUND_SPRITE_DURATION = 200;
    }

    public Schlange newInstance() {
        return new Schlange();
    }

    @Override
    public int getCoinEarnings() {
        int coinEarnings = 0;
        switch(world.getWellen().getDifficulty()) {
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
