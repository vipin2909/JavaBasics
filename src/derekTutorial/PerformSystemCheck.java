package derekTutorial;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;


// if we want to block run method by accessing two different threads at a prticular time
// this can be done in multiple ways

// if you type synchronized on any method whenever any other thread access this method its gonna be locked down
// no other thread gonna access this

// but this will slow down java
public class PerformSystemCheck implements Runnable {

    private String checkWhat;
    ReentrantLock lock = new ReentrantLock();
    public PerformSystemCheck(String checkWhat) {
        this.checkWhat = checkWhat;
    }

    // one way to protect it accessing from different threads using synchronized keyword
//    synchronized public void run() {
//
//    }
    public void run() {


        lock.lock();
        System.out.println("Checking " + this.checkWhat);
        lock.unlock();

    }
}
