import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Placer here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Placer extends Actor {

    Item item;

    public Placer(Item item) {
        setImage("images/ui/shop/" + item.iconName);
        this.item = item;
    }

    public void act() {
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null) {
            int x = m.getX();
            int y = m.getY();
            if(y > 550) {
                y = 670;
            } else if(y > 360) {
                y = 480;
            } else if(y > 170) {
                y = 290;
            } else {
                y = 100;
            }
            if(x > 875) {
                x = 875;
            }
            setLocation(x, y);
        }
        if(Greenfoot.mouseClicked(this)) {
            getWorld().addObject(item.newInstance(), getX(), getY());
            getWorld().removeObject(this);
        }
    }
}
