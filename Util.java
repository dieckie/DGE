import java.awt.*;
import greenfoot.*;

public class Util {

    public static Graphics2D drawMultilineText(String text, float x, float y, float width, float lineheight, boolean center, Graphics2D g) {
        String[] words = text.split(" ");
        int wordpos = 0;
        String lineText = "";
        while(wordpos < words.length) {
            while(wordpos < words.length && g.getFontMetrics(g.getFont()).stringWidth(lineText + " " + words[wordpos]) < width) {
                lineText += " " + words[wordpos];
                wordpos++;
            }
            if(center) {
                g.drawString(lineText, (float) (x + (width - g.getFontMetrics(g.getFont()).stringWidth(lineText)) * 0.5), y);
            } else {
                g.drawString(lineText, x, y);
            }
            lineText = "";
            y += lineheight;
        }
        return g;
    }

    public static GreenfootImage drawCoins(int coins) {
        GreenfootImage img = new GreenfootImage(350, 60);
        if(coins >= 150) {
            coins = 149;
        }
        int co = coins % 25;
        int bills = coins / 25;
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
        return img;
    }
}
