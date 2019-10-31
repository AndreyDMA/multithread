package multithreading;

public class Counter {
    private int count = 0;

    public Counter() {
    }

    public int incrementCount() {
        return count++;
    }
}
