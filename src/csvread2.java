import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class csvread2 {
    public static void main(String[] args) {
        String filepath = "kecamatanforecast-sulteng.csv";
        String IDTerm = "5012382";
        String timeTerm = "2021-12-28 12:00:00";
        String line = "";
        String splitBy = ";";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            while ((line = br.readLine()) != null) {
                String[] dataCSV = line.split(splitBy);

                if (dataCSV[0].equals(IDTerm) && dataCSV[1].equals(timeTerm)) {
                    System.out.println("ID: " + dataCSV[0] + ", Waktu: " + dataCSV[1] + ", Cuaca: " + dataCSV[8] + ", Suhu: " + dataCSV[7] + " Derajat, Kelembapan: " + dataCSV[6] + " %, Arah Angin: " + dataCSV[9]);;
                }

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
