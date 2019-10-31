package multithreadingCalculations;

import java.util.ArrayList;
import java.util.List;

public class NumberListFiller {
    private static final int SIZE = 1000000;

    public static List<Integer> fillList(List<Integer> numbers) {
        numbers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            numbers.add((int) (Math.random() * 100));
        }
        return numbers;
    }
}
