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
    Item[] items = {new Spikes(), new Wand(), new Herz(), new GoldeneEichel()};
    boolean[] oldKeysPressed;
    boolean init = true;
    GreenfootSound click = new GreenfootSound("shopClick.wav");
    GreenfootSound error = new GreenfootSound("error.wav");

    public Shop() {
    }

    /**
     * Act - do whatever the Shop wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(init) {
            init = false;
            world = (Welt1) getWorld();
            redrawShop();
            oldKeysPressed = new boolean[items.length];
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

    public void redrawShop() {
        shop = new GreenfootImage("images/ui/shop/shop.png");
        int welle = 1;
        if(world != null) {
            welle = world.wellen.welle;
        }
        for(int i = 0; i < items.length; i++) {

            if(welle >= items[i].unlock[Config.difficulty]) {
                shop.drawImage(new GreenfootImage("images/ui/shop/" + items[i].iconName), (i % 2) * 190 + 2 + 70, (i / 2) * 102 + 2 + 25);
            } else {
                shop.drawImage(Util.greyscale(new GreenfootImage("images/ui/shop/" + items[i].iconName)), (i % 2) * 190 + 2 + 70, (i / 2) * 102 + 2 + 25);
            }
        }
        setImage(shop);
    }

    public void addItem(Item it) {
        Item[] newI = new Item[items.length + 1];
        for(int i = 0; i < items.length; i++) {
            newI[i] = items[i];
        }
        newI[items.length] = it;
        items = newI;
        oldKeysPressed = new boolean[items.length];
        redrawShop();
    }

    public void keysPressed() {
        for(int i = 0; i < items.length; i++) {
            if(Greenfoot.isKeyDown((i + 1) + "")) {
                if(!oldKeysPressed[i]) {
                    kaufen(items[i]);

                    if(items[i].isPlaceable()) {
                        world.pause();
                    }
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
            if(item.isBuyable(world)) {
                if(world.wellen.welle >= item.unlock[Config.difficulty]) {
                    click.setVolume(75);
                    click.play();
                    world.coins.looseCoins(item.price);
                    if(item.isPlaceable()) {
                        world.addObject(new Placer(item), lastX, lastY);
                    } else {
                        world.addObject(item.newInstance(), 0, 0);
                    }
                    return;
                }
            }
        }
        error.setVolume(85);
        error.play();
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
                g.setColor(new Color(20, 20, 20));
                g = Util.drawMultilineText(item.description, 20, 605, 250, 25, false, g);
                g.dispose();
                img.drawImage(Util.drawCoins(item.price), 20, 660);
            }
            setImage(img);
            oldIndex = index;
        }
    }
}
