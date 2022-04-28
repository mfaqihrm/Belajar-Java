import java.util.Scanner;

public class AmbilData {

    private static Scanner x;
    String data0,data1,data2,data3,data4,data5,data6,data7,data8,data9,data10,data11,data12;
    /*  data0 = ID          data6 = rhNow           data11 = date
    *   data1 = time        data7 = tempNow         data12 = clock
    *   data2 = tempMin     data8 = weatherCode
    *   data3 = tempMax     data9 = windDirect
    *   data4 = rhMin       data10 = windSpeed
    *   data5 = rhMax
    * */

   AmbilData(String IDTerm, String timeTerm, String filepath) {
        boolean found = false;
        x = new Scanner(filepath);
        x.useDelimiter("[;\n]");

        while (x.hasNext() && !found) {
            data0 = x.next();
            data1 = x.next();
            data2 = x.next();
            data3 = x.next();
            data4 = x.next();
            data5 = x.next();
            data6 = x.next();
            data7 = x.next();
            data8 = x.next();
            data9 = x.next();
            data10 = x.next();

            if (data0.equals(IDTerm) && data1.equals(timeTerm)) {
                found = true;
            }
        }

        Scanner y = new Scanner(data1);
        y.useDelimiter(" ");
        while (y.hasNext()) {
            data11 = y.next();
            data12 = y.next();
        }
    }
}
