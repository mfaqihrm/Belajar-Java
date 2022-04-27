import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class testURLRead {
    private static Scanner x;

    private static String getUrlContents(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void main(String[] args) {
        String filepath = getUrlContents("https://data.bmkg.go.id/DataMKG/MEWS/DigitalForecast/CSV/kecamatanforecast-sulteng.csv");
        String IDTerm = "5012382";
        String timeTerm = "2022-04-28 12:00:00";

        readRecord(IDTerm,timeTerm,filepath);

    }

    public static void readRecord(String IDTerm,String timeTerm,String filepath) {
        boolean found = false;
        String ID = ""; String time = ""; String tempMin = ""; String tempMax = ""; String rhMin = ""; String rhMax = "";
        String rhNow = ""; String tempNow = ""; String weatherCode = ""; String windDirect = ""; String windSpeed = "";
        String date = ""; String clock = "";
        try {
            x = new Scanner(filepath);
            x.useDelimiter("[;\n]");

            while (x.hasNext() && !found) {
                ID = x.next();
                time = x.next();
                tempMin = x.next();
                tempMax = x.next();
                rhMin = x.next();
                rhMax = x.next();
                rhNow = x.next();
                tempNow = x.next();
                weatherCode = x.next();
                windDirect = x.next();
                windSpeed = x.next();

                if(ID.equals(IDTerm) && time.equals(timeTerm)) {
                    found = true;
                }

            }

            if (found) {
                //System.out.println(time);;
               // JOptionPane.showMessageDialog(null, "ID: " + ID + ", Waktu: " + time + ", Cuaca: " + weatherCode + ", Suhu: " + tempNow + " Derajat, Kelembapan: " + rhNow + " %, Arah Angin: " + windDirect);
            }
            else {
                JOptionPane.showMessageDialog(null,"Record not found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error");
        }

        //membuat variable baru untuk memisahkan antara tanggal dan jam
        Scanner y = new Scanner(time);
        y.useDelimiter(" ");
        while (y.hasNext()) {
            date = y.next();
            clock = y.next();
        }

        // Disini harusnya find Database dulu sesuai ID kecamatan, untuk mendapatkan baris nama Kecamatan, Kabupaten dan Provinsi
        String kodeKec = "5012382";
        String namaKec = "Ulubongka"; // mestinya string ini diambil dari database
        String namaKab = "Tojo Una-Una";
        String namaProv = "Sulawesi Tengah";

        //Bikin database baru untuk input kode cuaca dan maknanya
        String kodeCuaca = weatherCode;
        String cuaca = "Hujan Ringan"; //mestinya string ini diambil dari database sesuai dengan input kode cuaca

        //System.out.println(clock);

 /*      System.out.println("Cuaca di wilayah Kecamatan " + namaKec + ", Kab. " + namaKab + ", " +namaProv
                + " pada tanggal " + date + " pukul " + clock + " waktu setempat diperkirakan akan " + cuaca + ".\nDengan Suhu = " + tempNow +  " °C\n" +
                "Kelembapan = " + rhNow + " %\nKecepatan Angin = " + windSpeed + " m/s dari arah " + windDirect + ".");
 */   }
}
