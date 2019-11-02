package multithreadingCalculations;

import java.util.List;
import java.util.concurrent.Callable;

public class NumbersSumCallable implements Callable<Integer> {
    private List<Integer> numbers;
    private int sum = 0;

    @Override
    public Integer call() throws Exception {
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
