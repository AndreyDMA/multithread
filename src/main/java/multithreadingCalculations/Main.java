package multithreadingCalculations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Main {
    static int step = 100000;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> fullList = NumberListFiller.fillList(numbers);

        System.out.println("Calculation with ExecutorService...");
        int sumCal = 0;
        int start = 0;
        int  end = step;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            NumbersSumCallable callable = new NumbersSumCallable();
            callable.setNumbers(fullList.subList(start, end));
            Future<Integer> future = executorService.submit(callable);
            sumCal += future.get();
            start += step;
            end += step;
        }
        System.out.println("The sum is " + sumCal + "\n-----------------");
        executorService.shutdown();

        System.out.println("Calculation with ForkJoin...");
        int sumFork = 0;
        int startF = 0;
        int endF = step;
        for (int i = 0; i < 10; i++) {
            NumbersSumForkJoin forkJoin = new NumbersSumForkJoin();
            forkJoin.setNumbers(fullList.subList(startF, endF));
            Integer partSum = new ForkJoinPool().invoke(forkJoin);
            sumFork += partSum;
            startF += step;
            endF += step;
        }
        System.out.println("The sum is " + sumFork + "\n-----------------");
    }
}
