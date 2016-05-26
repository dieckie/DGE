import greenfoot.*;
import java.util.Scanner;
import java.io.*;

public class Config extends Config1 {

    BufferedReader br;
    Welt1 w;
    
    public Config(File f, Welt1 w) {
        br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("config.txt")));
        this.w = w;
    }

    public void config() {
        try {
            String line = br.readLine();
            if(line != null) {
                // String text = s.nextLine();
                String[] parts = line.split(" ");
                username = parts[0];
                password = parts[1];
                w.wellen.welle = Integer.parseInt(parts[2]);
                w.coins.coins = Integer.parseInt(parts[3]);
                w.getEichhoernchen().setHealth(Integer.parseInt(parts[4]));
                w.getWellen().setDifficulty(Integer.parseInt(parts[5]));
                saveWaves = w.wellen.welle;
                saveCoins = w.coins.coins;
                saveHealth = w.getEichhoernchen().getHealth();
                // for(String st : parts){
                // System.out.println(st);
                // }
            }
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
