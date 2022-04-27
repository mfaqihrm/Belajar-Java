import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class csvread {
    public static void main(String[] args) {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/test.csv"));
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(splitBy);

                if (employee[0].equals("Andrew")) {
                    System.out.println("Employee [First Name=" + employee[0] + ", Last Name=" + employee[1] + ", Designation=" + employee[2] + ", Contact=" + employee[3] + ", Salary= " + employee[4] + ", City= " + employee[5] +"]");
                }

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
