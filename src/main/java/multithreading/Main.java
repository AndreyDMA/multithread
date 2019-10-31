package multithreading;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        System.out.println("Hello from main thread " + Thread.currentThread().getName());
        ThreadE threadE = new ThreadE(counter);
        threadE.setName("thread extends Thread");
        threadE.start();
        ThreadR threadR = new ThreadR(counter);
        Thread thread = new Thread(threadR);
        thread.setName("thread implements Runnable");
        thread.start();
    }
}
