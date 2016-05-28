import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Ratte2 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ratte extends Enemy {

    public Ratte() {
        setImage("images/enemy/mouse_r.png");
        DAMAGE = 1;
        SPEED = 1;
        HEALTH = 5;
        SPRITE_NAME = "mouse";
        WOUND_SPRITE_DURATION = 200;
    }

    @Override
    public Ratte newInstance() {
        return new Ratte();
    }

    @Override
    public int getCoinEarnings() {
        int coins = 1;
        switch(world.getWellen().getDifficulty()) {
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
