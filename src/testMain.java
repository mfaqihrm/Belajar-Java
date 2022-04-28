import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class testMain {

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
        String timeTerm = "2022-04-30 12:00:00";

        var ambilData0 = new AmbilData(IDTerm, timeTerm, filepath);
        String kodeWilayah = ambilData0.data0;
        String tanggal = ambilData0.data11;
        String jam = ambilData0.data12;
        String kelembapan = ambilData0.data6;
        String suhu = ambilData0.data7;
        String kodeCuaca = ambilData0.data8;
        String arahAngin = ambilData0.data9;
        String kecAngin = ambilData0.data10;

        // Disini harusnya find Database dulu sesuai ID kecamatan, untuk mendapatkan baris nama Kecamatan, Kabupaten dan Provinsi
        String namaKec = "Ulubongka"; // mestinya string ini diambil dari database
        String namaKab = "Tojo Una-Una";
        String namaProv = "Sulawesi Tengah";

        String cuaca = "";
        if (kodeCuaca.equals("0")) {
            cuaca = "Cerah";
        }
        else if (kodeCuaca.equals("1")) {
            cuaca = "Cerah Berawan";
        }
        else if (kodeCuaca.equals("2")) {
            cuaca = "Cerah Berawan";
        }
        else if (kodeCuaca.equals("3")) {
            cuaca = "Berawan";
        }
        else if (kodeCuaca.equals("4")) {
            cuaca = "Berawan Tebal";
        }
        else if (kodeCuaca.equals("5")) {
            cuaca = "Udara Kabur";
        }
        else if (kodeCuaca.equals("10")) {
            cuaca = "Asap";
        }
        else if (kodeCuaca.equals("45")) {
            cuaca = "Kabut";
        }
        else if (kodeCuaca.equals("60")) {
            cuaca = "Hujan Ringan";
        }
        else if (kodeCuaca.equals("61")) {
            cuaca = "Hujan Sedang";
        }
        else if (kodeCuaca.equals("63")) {
            cuaca = "Hujan Lebat";
        }
        else if (kodeCuaca.equals("80")) {
            cuaca = "Hujan Lokal";
        }
        else if (kodeCuaca.equals("95")) {
            cuaca = "Hujan Petir";
        }
        else if (kodeCuaca.equals("97")) {
            cuaca = "Hujan Petir";
        }
        else {
            cuaca = null;
        }


        //System.out.println(clock);
        System.out.println("Cuaca di wilayah Kecamatan " + namaKec + ", Kab. " + namaKab + ", " + namaProv
                + " pada tanggal " + tanggal + " pukul " + jam + " waktu setempat diperkirakan akan " + cuaca + ".\nDengan Suhu = " + suhu +  " °C\n" +
                "Kelembapan = " + kelembapan + " %\nKecepatan Angin = " + kecAngin + " m/s dari arah " + arahAngin + ".");

    }
}
