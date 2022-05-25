import java.util.concurrent.locks.ReentrantLock;
public class PerformSystemCheck implements Runnable{
    // this is for lesson 18

    private String checkWhat;

    ReentrantLock lock = new ReentrantLock();
    public PerformSystemCheck(String checkWhat) {
        this.checkWhat = checkWhat;
    }
    // one way to protect this method is to put synchronized keyword in front of the method
    // ex. synchronized public void run() -> this will lock this thread and prevent from being accessed by another thread
    // but this will make java slow (but this is a way to do this)
    public void run() {
        lock.lock();
        System.out.println("Checking "+this.checkWhat);
        lock.unlock();
    }
}
