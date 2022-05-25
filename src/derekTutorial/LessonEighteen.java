package derekTutorial;


import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit.*;


// in this we will use predefined time stamps


public class LessonEighteen {

    public static void main(String[] args) {
        addThreadsToPool();
    }

    public static void addThreadsToPool() {
        ScheduledThreadPoolExecutor eventPool = new ScheduledThreadPoolExecutor(5);

        eventPool.scheduleAtFixedRate(new CheckSystemTime(), 0, 2, TimeUnit.SECONDS);
        eventPool.scheduleAtFixedRate(new PerformSystemCheck("Mail"), 5, 5, TimeUnit.SECONDS);
        eventPool.scheduleAtFixedRate(new PerformSystemCheck("Calendar"), 10, 10, TimeUnit.SECONDS);

        System.out.println(" Number of Threads " + Thread.activeCount());

        Thread[] listOfThread = new Thread[Thread.activeCount()];

        Thread.enumerate(listOfThread);
        for(Thread i: listOfThread) {
            System.out.println(i.getName());

        }

        for(Thread i: listOfThread) {
            System.out.println(i.getPriority());
        }

        // we can also setPriority 1 is of low priority and 10 is of high priority
        // we can set priority using threadName.setPriority():

        eventPool.shutdown();
        try {
            Thread.sleep(20000);


        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }



    }
}
