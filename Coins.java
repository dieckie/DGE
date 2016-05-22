import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)     
import java.awt.*;     
     
/**     
 * Write a description of class coins here.     
 *      
 * @author (your name)     
 * @version (a version number or a date)     
 */     
public class Coins extends OpenVariable {     
     
    int coins = 0;     
     
    /**     
     * Act - do whatever the coins wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.     
     */     
    public void act() {     
        if(Greenfoot.isKeyDown("c")) {     
            coins++;     
            draw();     
        }     
    }     
     
    /**     
     * verändert die Anzeige bei erhalten eines Coins(C).     
     */     
    public void draw() {     
        //System.out.println("COINS");     
        if(coins < 150) {     
            int co = coins % 25;     
            int bills = coins / 25;     
            GreenfootImage img = new GreenfootImage(350, 60);     
            int coin5amount = co / 5;     
            int coinsLeft = co % 5;     
            int x = 350;     
            GreenfootImage five = new GreenfootImage("images/Coins/C5.png");     
            for(int i = 0; i < coin5amount; i++) {     
                img.drawImage(five, x - five.getWidth(), 0);     
                x -= 40;     
            }     
            if(coinsLeft > 0) {     
                GreenfootImage leftOver = new GreenfootImage("images/Coins/C" + coinsLeft + ".png");     
                img.drawImage(leftOver, x - leftOver.getWidth(), 0);     
                x -= 40;     
            }     
            if(bills > 0) {     
                GreenfootImage bill = new GreenfootImage("images/Coins/Bill" + bills + ".png");     
                img.drawImage(bill, x - bill.getWidth() - 5, 0);     
            }     
            img.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));     
            img.setColor(new Color(200, 200, 200));     
            img.drawString(coins + "", -3, 37);     
            setImage(img);     
        }     
    }     
     
    public void earnCoins(int coins) {     
        this.coins += coins;     
        draw();     
    }     
     
    public void lostCoins(int coins) {     
        this.coins -= coins;     
        draw();     
    }     
}     
