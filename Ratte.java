import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      

/**
 * Write a description of class Ratte2 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ratte extends Enemy {
    public Ratte() {
        setImage("images/entity/mouse_r.png");
        DAMAGE = 1;
        SPEED = 1;
        SPRITE_NAME = "mouse";
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

    @Override
    public Ratte newInstance() {
        return new Ratte();
    }

    @Override
    public int getCoinEarnings(int difficulty) {
        switch(difficulty) {
            case 1:
            return 1;
            case 2:
            return 2;
            case 3:
            return 3;
        }
        return 0;
    }
}
