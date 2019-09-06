public class main {
    static SomeThing mThing;

    public static void main(String[] args) {
        mThing = new SomeThing();
        Thread myThread = new Thread(mThing);
        myThread.start();

        System.out.println("Главный поток завершен");
    }
}
