import java.io.*;
import java.net.URL;

public class csvread1 {
    public static void main(String[] args) {
        String line = "";
        String splitBy = ";";
        try {
            URL url = new URL("https://data.bmkg.go.id/DataMKG/MEWS/DigitalForecast/CSV/kecamatanforecast-banten.csv");
            try (InputStream in = url.openStream();
                 InputStreamReader inr = new InputStreamReader(in);
                 BufferedReader br = new BufferedReader(inr)) {
                line = br.readLine();
                System.out.println(line);
                while (line != null) {
                    String[] dataArray = line.split(splitBy);
                    System.out.println("Cuaca di wilayah " + dataArray[0] + " pada " + dataArray[1] + " adalah " + dataArray[8]);
                }
            }
        }
        catch (Exception f) {
            f.printStackTrace();
        }
    }
}
