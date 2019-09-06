import com.oracle.jrockit.jfr.*;
import mexaneg.blocking.queue.*;
import mexaneg.blocking.queue.Producer;

import java.util.*;

public class main {
    static SomeThing mThing;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new BlockingQueue<>();

        //  for (int i = 0; i < 2; i++) {
        Thread tr = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Thread.sleep(51);
                    adding(queue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread tr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
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

    static void adding(BlockingQueue<Integer> queue) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            queue.put(i);
            Thread.sleep(1);
        }
    }
}
