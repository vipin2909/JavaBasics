package derekTutorial;

import java.text.SimpleDateFormat;
import java.util.*;
import java.text.DateFormat;

public class GetTime20 extends Thread {


    // always run methods runs on priority
    @Override
    public void run() {
        Date rightNow;
        Locale currentLocale;
        DateFormat timeFormatter;
        DateFormat dateFormatter;
        String timeOutput;
        String dateOutput;

        for(int i = 0; i <= 20; i+=1) {

            rightNow = new Date();
            currentLocale = new Locale("en");

            // styles DEFAULT, SHORT, MEDIUM, LONG OR FULL
            timeFormatter = DateFormat.getTimeInstance(DateFormat.LONG);
            dateFormatter = DateFormat.getDateInstance(DateFormat.LONG);

            timeOutput = timeFormatter.format(rightNow);
            dateOutput = dateFormatter.format(rightNow);


            System.out.println(timeOutput);
            System.out.println(dateOutput);
            System.out.println("timeFormatter " + timeFormatter.toString());

            try {
                Thread.sleep(2000);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
