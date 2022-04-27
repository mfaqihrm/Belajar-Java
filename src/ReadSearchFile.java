import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class ReadSearchFile {

    private static Scanner x;

    public static void main(String[] args) {
        String filepath = "src/tutorial.txt";
        String searchTerm = "5464";

        readRecord(searchTerm,filepath);
    }

    public static void readRecord(String searchTerm, String filepath) {
        boolean found = false;
        String ID = ""; String name1 = ""; String age = "";

        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {
                ID = x.next();
                name1 = x.next();
                age = x.next();

                if(ID.equals(searchTerm)) {
                    found = true;
                }

            }

            if (found) {
                JOptionPane.showMessageDialog(null, "ID: " + ID + " Name: " + name1 + " Age: " +age);
            }
            else {
                JOptionPane.showMessageDialog(null,"Record not found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error");
        }

    }
}
