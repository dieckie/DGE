 

import greenfoot.*;
import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Config {
    
    static String username, password;
    static int saveWaves, saveCoins, saveHealth, difficulty;

    public static void config(Welt1 w) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("config.txt"));
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
                difficulty = Integer.parseInt(parts[5]);
                saveWaves = w.wellen.welle;
                saveCoins = w.coins.coins;
                saveHealth = w.getEichhoernchen().getHealth();
            }
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void speichern() {
        ExecutorService exe = Executors.newFixedThreadPool(1);
        exe.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    String body = "username=" + URLEncoder.encode(username, "UTF-8") + "&password=" + URLEncoder.encode(password, "UTF-8") + "&wave=" + URLEncoder.encode(saveWaves + "", "UTF-8") + "&coins="
                            + URLEncoder.encode(saveCoins + "", "UTF-8") + "&health=" + URLEncoder.encode(saveHealth + "", "UTF-8");
                    // System.out.println(body);
                    URL url = new URL("http://dieckie.bplaced.net/kolja/update.php");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setUseCaches(false);
                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    connection.setRequestProperty("Content-Length", String.valueOf(body.length()));
                    OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
                    writer.write(body);
                    writer.flush();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    for(String line; (line = reader.readLine()) != null;) {
                        System.out.println(line);
                    }
                    writer.close();
                    reader.close();
                    
                    BufferedWriter bw = new BufferedWriter(new FileWriter("config.txt"));
                    bw.write(username + " " + password + " " + saveWaves + " " + saveCoins + " " + saveHealth + " " + difficulty);
                    bw.close();
                    
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
