import java.util.concurrent.locks.ReentrantLock;


public class PerformSystemCheck implements Runnable {

    private String checkWhat;

    ReentrantLock lock = new ReentrantLock();

    public PerformSystemCheck(String checkWhat) {
        this.checkWhat = checkWhat;
    }

//    // locked down method by synchonizing
//    synchronized public void run() {
//
//    }

    // Alternative method of locking method
    // it becomes inaccessible by more than one thread
    public void run() {
        lock.lock();
        System.out.println("Checking: " + this.checkWhat);
        lock.unlock();
    }
}
