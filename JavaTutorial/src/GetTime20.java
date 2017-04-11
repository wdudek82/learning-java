import java.util.*;
import java.text.DateFormat;


public class GetTime20 extends Thread {
    public void run() {
        Date rightNow;
        Locale currentLocale;
        DateFormat timeFormatter;
        DateFormat dateFormatter;
        String timeOutput;
        String dateOutput;

        for (int i = 1; i <= 20; i++) {
            rightNow = new Date();
            currentLocale = new Locale("en");

            // DEFAULT: Apr 11, 2017 11:39:14 PM
            // SHORT: 4/11/17 11:41 PM
            // MEDIUM: Apr 11, 2017 11:40:31 PM
            // LONG: April 11, 2017 11:38:49 PM CEST
            // FULL: Tuesday, April 11, 2017 11:39:47 PM CEST
            timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
            dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);

            timeOutput = timeFormatter.format(rightNow);
            dateOutput = dateFormatter.format(rightNow);

            System.out.println(dateOutput + " " + timeOutput);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //
            }
        }
    }
}
