import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class csvscanner2 {
    public static final String CSV_FILE_URL = "https://data.bmkg.go.id/DataMKG/MEWS/DigitalForecast/CSV/kecamatanforecast-banten.csv";

    public static void main(String[] args) throws IOException {
        int m, n, i, j;
        URL url = new URL(CSV_FILE_URL);
        Scanner sc=new Scanner(url.openConnection().getInputStream());
        System.out.print("Enter the number of rows: ");
//taking row as input
        m = sc.nextInt();
        System.out.print("Enter the number of columns: ");
//taking column as input
        n = sc.nextInt();
// Declaring the two-dimensional matrix
        int array[][] = new int[m][n];
// Read the matrix values
        System.out.println("Enter the elements of the array: ");
//loop for row
        for (i = 0; i < m; i++)
//inner for loop for column
            for (j = 0; j < n; j++)
                array[i][j] = sc.nextInt();
//accessing array elements
        System.out.println("Elements of the array are: ");
        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
//prints the array elements
                System.out.print(array[i][j] + " ");
//throws the cursor to the next line
            System.out.println();
        }
    }
}
