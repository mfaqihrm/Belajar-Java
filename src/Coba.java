import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Coba {
    private static Scanner x;
    public static void main(String[] args) {
        String searchTerm = "5008824";
        String line = "";

        try {
            URL url = new URL("https://data.bmkg.go.id/DataMKG/MEWS/DigitalForecast/CSV/kecamatanforecast-banten.csv");
            try (InputStream in = url.openStream();
                 InputStreamReader inr = new InputStreamReader(in);
                 BufferedReader bf = new BufferedReader(inr)) {
                line = bf.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        readRecord(searchTerm, line);
    }

    public static void readRecord(String searchTerm, String line) {
        boolean found = false;
        String ID = ""; String tanggalJam = ""; String suhuMin = ""; String suhuMax = ""; String rhMin = "";
        String rhMax = ""; String rh = ""; String suhu = ""; String kodeCuaca = ""; String arahAngin = ""; String kecAngin = "";

        try {
            x = new Scanner(new File(line));
            x.useDelimiter("[;\n]");

            while (x.hasNext() && !found) {
                ID = x.next();
                tanggalJam = x.next();
                suhuMin = x.next();
                suhuMax = x.next();
                rhMin = x.next();
                rhMax = x.next();
                rh = x.next();
                suhu = x.next();
                kodeCuaca = x.next();
                arahAngin = x.next();
                kecAngin = x.next();

                if(ID.equals(searchTerm)) {
                    found = true;
                }

            }

            if (found) {
                JOptionPane.showMessageDialog(null, "ID: " + ID + " Kode Cuaca : " + kodeCuaca);
            }
            else {
                JOptionPane.showMessageDialog(null,"Record not found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error");
        }

    }
}
