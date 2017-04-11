import java.util.*;
import java.text.DateFormat;


public class CheckSystemTime implements Runnable {
    public void run() {
        Date rightNow = new Date();
        Locale currentLocale = new Locale("en");
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
        String timeOutput = timeFormatter.format(rightNow);

        System.out.println("Time: " + timeOutput);
    }
}
