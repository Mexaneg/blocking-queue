package mexaneg.blocking.queue;

import java.util.*;
import java.util.concurrent.*;

public class BlockingQueue<T> {
    private ArrayList<T> queue = new ArrayList<T>();

    public synchronized void put(T o) {
        queue.add(o);
    }

    public synchronized T take() {

        return queue.remove(0);

    }

    public int size() {
        return queue.size();
    }

    @Override
    public synchronized String toString() {
        return "BlockingQueue{" +
                "queue=" + queue +
                '}';
    }
}
