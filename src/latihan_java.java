import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

public class latihan_java {
    public static void main(String[] args) {
       try {
           URL url = new URL("https://data.bmkg.go.id/DataMKG/MEWS/DigitalForecast/CSV/kecamatanforecast-banten.csv");
           try (InputStream in = url.openStream();
                InputStreamReader inr = new InputStreamReader(in);
                BufferedReader bf = new BufferedReader(inr)) {
               String line = bf.readLine();
               while (line != null) {
                   String[] elements = line.split(";");
                   System.out.println(line);
                   line = bf.readLine();
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }

    }
}
