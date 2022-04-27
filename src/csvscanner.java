import java.io.File;
import java.util.Scanner;

public class csvscanner {
    public static void main(String[] args) throws Exception {
        Scanner dataCSV = new Scanner(new File("src/test.csv"));
        dataCSV.useDelimiter(",");
        while (dataCSV.hasNext()) {
            System.out.print(dataCSV.next());
        }
        dataCSV.close();
    }
}
