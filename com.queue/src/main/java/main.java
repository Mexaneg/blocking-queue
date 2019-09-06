import threads.*;

public class main {
    static SomeThing mThing;

    public static void main(String[] args) {
       /* mThing = new SomeThing();
        Thread myThread = new Thread(mThing);
        myThread.start();

        System.out.println("Главный поток завершен");
                */
        //one thread
        //LiftOff launch = new LiftOff();
        //launch.run();

        //multithread
        for (int i =0; i<5; i++){
            Thread t = new Thread(new LiftOff());
            t.start();
        }

        System.out.println("Waithing LiftOff");

    }
}
