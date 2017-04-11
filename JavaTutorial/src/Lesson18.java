import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit.*;


public class Lesson18 {
    public static void main(String[] args){
        addThreadsToPool();
    }

    public static void addThreadsToPool() {
        ScheduledThreadPoolExecutor eventPool = new ScheduledThreadPoolExecutor(5);

        eventPool.scheduleAtFixedRate(new CheckSystemTime(), 0, 1, TimeUnit.SECONDS);
        eventPool.scheduleAtFixedRate(new PerformSystemCheck("Mail check"), 5, 5, TimeUnit.SECONDS);
        eventPool.scheduleAtFixedRate(new PerformSystemCheck("Callendar check"), 10, 10, TimeUnit.SECONDS);

        System.out.println("Number of Threads: " + Thread.activeCount());

        Thread[] listOfThreads = new Thread[Thread.activeCount()];

        Thread.enumerate(listOfThreads);
        for (Thread thread : listOfThreads) {
            System.out.println("Thread: " + thread.getName());
        }
        System.out.println();

        for (Thread thread : listOfThreads) {
            System.out.println("Threads priority: " + thread.getPriority());
        }
        System.out.println();

        // lowest priority: 10
        // threadName.setPriority(3);

//        eventPool.shutdown();

        // To limit execution time
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
    }
}
