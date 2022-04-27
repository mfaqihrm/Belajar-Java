import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class ReadSearch1 {
    private static Scanner x;

    public static void main(String[] args) {
        String filepath = "kecamatanforecast-sulteng.csv";
        String IDTerm = "5012382";
        String timeTerm = "2021-12-28 12:00:00";

        readRecord(IDTerm,timeTerm,filepath);
    }

    public static void readRecord(String IDTerm,String timeTerm,String filepath) {
        boolean found = false;
        String ID = ""; String time = ""; String tempMin = ""; String tempMax = ""; String rhMin = ""; String rhMax = "";
        String rhNow = ""; String tempNow = ""; String weatherCode = ""; String windDirect = ""; String windSpeed = "";

        try {
            x = new Scanner(new File(filepath));
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
                //JOptionPane.showMessageDialog(null, "ID: " + ID + ", Waktu: " + time + ", Cuaca: " + weatherCode + ", Suhu: " + tempNow + " Derajat, Kelembapan: " + rhNow + " %, Arah Angin: " + windDirect);
            }
            else {
                JOptionPane.showMessageDialog(null,"Record not found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error");
        }

        // Disini harusnya find Database dulu sesuai ID kecamatan, untuk mendapatkan baris nama Kecamatan, Kabupaten dan Provinsi
        String kodeKec = "5012382";
        String namaKec = "Ulubongka"; // mestinya string ini diambil dari database
        String namaKab = "Tojo Una-Una";
        String namaProv = "Sulawesi Tengah";

        //Bikin database baru untuk input kode cuaca dan maknanya
        String kodeCuaca = weatherCode;
        String cuaca = "Hujan Ringan"; //mestinya string ini diambil dari database sesuai dengan input kode cuaca

        //membuat variable baru untuk memisahkan antara tanggal dan jam
        Scanner y = new Scanner(time);
        y.useDelimiter(" ");
        String date = ""; String clock = "";
        while (y.hasNext()) {
            date = y.next();
            clock = y.next();
        }
        //System.out.println(clock);

        System.out.println("Cuaca di wilayah Kecamatan " + namaKec + ", Kab. " + namaKab + ", " +namaProv
                + " pada tanggal " + date + " pukul " + clock + " waktu setempat diperkirakan akan " + cuaca + ".\nDengan Suhu = " + tempNow +  " Derajat Celcius\n" +
                "Kelembapan = " + rhNow + " %\nKecepatan Angin = " + windSpeed + " m/s dari arah " + windDirect + ".");

    }
}
