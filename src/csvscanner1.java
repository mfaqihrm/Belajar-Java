import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class csvscanner1 {
    public static final String CSV_FILE_URL = "https://data.bmkg.go.id/DataMKG/MEWS/DigitalForecast/CSV/kecamatanforecast-banten.csv";

    public static void main(String[] args) throws IOException {
        URL url = new URL(CSV_FILE_URL);
        Scanner dataCSV = new Scanner(url.openConnection().getInputStream());
        dataCSV.useDelimiter(";");
        System.out.println(dataCSV.next());
/*        while (dataCSV.hasNext()) {
            System.out.print(dataCSV.next());
        }

 */
        dataCSV.close();
    }
}
