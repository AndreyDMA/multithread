package multithreadingCalculations;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class NumbersSumForkJoin extends RecursiveTask<Integer> {
    private List<Integer> numbers;
    private int sum = 0;

    @Override
    protected Integer compute() {
        System.out.println(Thread.currentThread().getName());
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
