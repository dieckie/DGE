import greenfoot.*;      
import java.util.Scanner;      
import java.io.*;      
      
public class Config extends Config1 {      
      
    BufferedReader br;      
      
    public Config(File f) {      
        br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("config.txt")));      
    }      
      
    public void config() {      
        try {      
            String line = br.readLine();      
            if(line != null) {      
                // String text = s.nextLine();      
                String[] parts = line.split(" ");      
                username = parts[0];      
                password = parts[1];      
                W = Integer.parseInt(parts[2]);      
                C = Integer.parseInt(parts[3]);      
                l = Integer.parseInt(parts[4]);      
                saveWaves = W;      
                saveCoins = C;      
                saveHealth = l;      
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
