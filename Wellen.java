import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      
import java.io.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Write a description of class Wellen here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wellen extends Actor {
    
    
    Welt1 world;
    String[] wellen;
    boolean init = true;
    int welle = 0;
    private int h = 0;
    int livingEnemys = 0;
    
    public Wellen() {
        welle = Config.saveWaves;
    }

    public void initWaves() {
        try {
            int lines = 0;
            String line;
            BufferedReader br = br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("wellen/wellen" + Config.difficulty + ".txt")));
            while(br.readLine() != null) {
                lines++;
            }
            wellen = new String[lines + 1];
            br = br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("wellen/wellen" + Config.difficulty + ".txt")));
            for(int i = 1; ((line = br.readLine()) != null); i++) {
                wellen[i] = line;
            }
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    public void act() {
        if(livingEnemys == 0) {
            if(init) {
                world = (Welt1) getWorld();
                init = false;
            } else {
                welle++;
                world.neueWelle(welle);
            }
            String[] spawners = wellen[welle].split("\\|");
            for(int i = 0; i < spawners.length; i++) {
                spawn(spawners[i]);
            }
            picture();
        }
    }

    private void picture() {
        GreenfootImage img = new GreenfootImage(250, 100);
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("font/ltromatic.ttf")).deriveFont(30f);
            img.setFont(font);
        } catch(FontFormatException | IOException e) {
            e.printStackTrace();
        }
        img.setColor(new Color(255, 137, 2));
        img.drawString("Welle " + welle, 15, (img.getHeight() + font.getSize()) / 2);
        setImage(img);
    }

    public void spawn(String spawn) {
        // "r/s [amount] [interval] <delay>"
        String[] parts = spawn.split(" ");
        if(parts.length == 4 || parts.length == 3) {
            int amount = Integer.parseInt(parts[1]);
            if(amount > 0) {
                int interval = Integer.parseInt(parts[2]);
                int delay = interval;
                if(parts.length == 4) {
                    delay = Integer.parseInt(parts[3]);
                }
                String n = parts[0];
                if(n.contains("r")) {
                    getWorld().addObject(new Spawner(new Ratte(), interval, amount, delay), 57, 670);
                    livingEnemys += amount;
                } else if(n.contains("s")) {
                    getWorld().addObject(new Spawner(new Schlange(), interval, amount, delay), 57, 670);
                    livingEnemys += amount;
                }
            }
        }
    }

    public void enemyDied() {
        livingEnemys--;
    }
}
