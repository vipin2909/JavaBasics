import java.sql.Time;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit.*;

public class LessonEighteen {
    public static void main(String[] args) {
        addThreadsToPool();
    }
    public static void addThreadsToPool() {
       ScheduledThreadPoolExecutor eventPool = new ScheduledThreadPoolExecutor(5);

       eventPool.scheduleAtFixedRate(new CheckSystemTime(), 0, 2, TimeUnit.SECONDS);
       eventPool.scheduleAtFixedRate(new PerformSystemCheck("Mail"), 5, 5, TimeUnit.SECONDS);
       eventPool.scheduleAtFixedRate(new PerformSystemCheck("Calendar"), 10, 10, TimeUnit.SECONDS);

        System.out.println("Number of threads "+Thread.activeCount());
        Thread[] listOfThread = new Thread[Thread.activeCount()];

        Thread.enumerate(listOfThread);
        for(Thread i: listOfThread) {
            System.out.println(i.getName());
        }
        int k = 1;
        for(Thread i: listOfThread) {
            i.setPriority(k++);
            System.out.println(i.getPriority());
        }
        eventPool.shutdown();
        // for how long thread should run we can define time period
        try {
            Thread.sleep(20000);
        }
        catch(InterruptedException e) {

        }

    }
}
