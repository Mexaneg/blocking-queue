public class SomeThing implements Runnable {
    @Override
    public void run() {
        System.out.println("Побочный поток запущен");
    }
}
