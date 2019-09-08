
import queue.BlockingQueue;

import java.util.concurrent.*;

public class main {


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new BlockingQueue<>();
        Semaphore S = new Semaphore(1, true);

        //  for (int i = 0; i < 2; i++) {
        Thread tr = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Thread.sleep(51);

                    adding(queue, S);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread tr2 = new Thread(new Runnable() {
            private volatile boolean play = true;

            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        S.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(queue.take());
                }

            }

        });
        tr.start();
        tr2.start();


        //  }
        Thread.sleep(1500);
        //adding(queue);
        //tr.join();
        System.out.print(queue.toString());
    }

    static void adding(BlockingQueue<Integer> queue, Semaphore S) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            queue.put(i);
            Thread.sleep(20);
            S.release();
        }
    }
}