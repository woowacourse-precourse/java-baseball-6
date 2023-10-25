package baseball;

import java.util.List;

public class BallCounter extends Counter {
    @Override
    public boolean compare(List<Integer> computer, List<Integer> number, Integer n) {
        return computer.contains(n) && computer.indexOf(n) != number.indexOf(n);
    }
}
