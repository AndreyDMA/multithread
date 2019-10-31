package multithreading;

public class ThreadR implements Runnable {
    private Counter counter;

    public ThreadR(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(counter.incrementCount() + " -> " + Thread.currentThread().getName());
        }
    }
}
