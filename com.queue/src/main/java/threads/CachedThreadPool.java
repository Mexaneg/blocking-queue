package threads;

import java.util.concurrent.*;

public class CachedThreadPool {
    public static void main (String[] args){
        CachedThreadPool.executeThreads(10);
    }
    private static void executeThreads(int num){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<num;i++){
            exec.execute(new SleepThreads());
        }
        exec.shutdown();
    }
}
