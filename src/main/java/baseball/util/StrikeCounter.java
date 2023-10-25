package baseball.util;

import java.util.List;

public class StrikeCounter implements Counter {
    @Override
    public boolean compare(List<Integer> computer, List<Integer> number, Integer n) {
        return computer.indexOf(n) == number.indexOf(n);
    }
}
