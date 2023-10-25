package baseball.util;

import java.util.List;

public interface Counter {
    boolean compare(List<Integer> computer, List<Integer> number, Integer n);

    default int count(List<Integer> computer, List<Integer> number) {
        return (int) number.stream()
                .filter(n -> compare(computer, number, n))
                .count();
    }
}
