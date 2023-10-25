package baseball;

import java.util.List;

public abstract class Counter {
    abstract boolean compare(List<Integer> computer, List<Integer> number, Integer n);

    int count(List<Integer> computer, List<Integer> number) {
        return (int) number.stream()
                .filter(n -> compare(computer, number, n))
                .count();
    }
}
