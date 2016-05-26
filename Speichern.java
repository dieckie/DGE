import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)      
import java.net.*;
import java.io.*;
import java.util.concurrent.*;

/**
 * Write a description of class Speichern here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Speichern {
    
    public static void speichern() {
        ExecutorService exe = Executors.newFixedThreadPool(1);
        exe.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    String body = "username=" + URLEncoder.encode(OpenVariable.username, "UTF-8") + "&password=" + URLEncoder.encode(OpenVariable.password, "UTF-8") + "&wave=" + URLEncoder.encode(OpenVariable.saveWaves + "", "UTF-8") + "&coins=" + URLEncoder.encode(OpenVariable.saveCoins + "", "UTF-8") + "&health="
                            + URLEncoder.encode(OpenVariable.saveHealth + "", "UTF-8");
                    //System.out.println(body);
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
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
