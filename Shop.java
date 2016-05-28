import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      
import java.io.*;
import java.awt.*;

//PERFORMANCE Bilder speichern und nur neu aufrufen
public class Shop extends Actor {

    final static int MAX_ITEMS = 8;
    int lastX, lastY;
    int index = -1;
    Welt1 world;
    GreenfootImage shop;
    Item[] items = {new Spikes(), new Wand(), new Herz()};
    boolean[] oldKeysPressed;
    boolean init = true;

    public Shop() {
        shop = new GreenfootImage("images/ui/shop/shop.png");
        for(int i = 0; i < items.length; i++) {
            shop.drawImage(new GreenfootImage("images/ui/shop/" + items[i].iconName), (i % 2) * 190 + 2 + 70, (i / 2) * 102 + 2 + 25);
        }
        setImage(shop);
        oldKeysPressed = new boolean[items.length];
    }

    /**
     * Act - do whatever the Shop wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(init) {
            init = false;
            world = (Welt1) getWorld();
        }
        greenfoot.MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null) {
            lastX = m.getX();
            lastY = m.getY();
        }
        getIndex();
        checkClicks();
        repaint();
        keysPressed();
    }

    public void keysPressed() {
        for(int i = 0; i < items.length; i++) {
            if(Greenfoot.isKeyDown((i + 1) + "")) {
                if(!oldKeysPressed[i]) {
                    kaufen(items[i]);
                    world.pause();
                    oldKeysPressed[i] = true;
                }
            } else {
                oldKeysPressed[i] = false;
            }
        }
    }

    public void getIndex() {
        if(lastX > 900) {
            world.pause();
            int x = lastX;
            int y = lastY;
            if(y < 512) {
                int row = y / 102;
                x -= 900;
                int column = 0;
                if(x > 190) {
                    column = 1;
                }
                index = row * 2 + column;
                if(index >= items.length) {
                    index = -1;
                }
                return;
            }
        }
        index = -1;
    }

    public void checkClicks() {
        if(Greenfoot.mouseClicked(this)) {
            if(index != -1) {
                if(index < items.length) {
                    kaufen(items[index]);
                }
            }
        }
    }

    public void kaufen(Item item) {
        if(world.coins.coins >= item.price) {
            world.coins.looseCoins(item.price);
            if(item.isBuyable(world)) {
                if(item.isPlaceable()) {
                    world.addObject(new Placer(item), lastX, lastY);
                } else {
                    world.addObject(item.newInstance(), 0, 0);
                }
            }
        }
    }

    int oldIndex = -1;

    public void repaint() {
        if(index != oldIndex) {
            GreenfootImage img = new GreenfootImage(shop);
            if(index != -1) {
                Item item = items[index];
                Graphics2D g = img.getAwtImage().createGraphics();
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setColor(Color.BLACK);
                try {
                    Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("font/ltromatic.ttf")).deriveFont(30f);
                    g.setFont(font.deriveFont(25));
                } catch(FontFormatException | IOException e) {
                    e.printStackTrace();
                }
                g.drawString(item.title, 20, 562);
                g.setFont(g.getFont().deriveFont(15F));
                g.setColor(new Color(50, 50, 50));
                g = Util.drawMultilineText(item.description, 20, 605, 250, 25, false, g);
                g.dispose();
                img.drawImage(Util.drawCoins(item.price), 30, 660);
            }
            setImage(img);
            oldIndex = index;
        }
    }
}
