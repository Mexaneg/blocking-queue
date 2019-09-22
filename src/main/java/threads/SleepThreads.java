package threads;

import java.util.*;

public class SleepThreads implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    private Random rnd = new Random();
    private int sleepTime;

    public SleepThreads() {
        sleepTime = rnd.nextInt(10);
    }

    public SleepThreads(int countDown) {
        this.countDown = countDown;
        sleepTime = rnd.nextInt(10);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("#"+id+" Время сна составило  " + sleepTime + " с");


    }
}
