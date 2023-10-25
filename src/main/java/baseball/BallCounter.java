package baseball;

import java.util.List;

public class BallCounter implements Counter {
    public int judge(List<Integer> computer, List<Integer> number) {
        return (int) number.stream()
                .filter(n -> compare(computer, number, n))
                .count();
    }

    private boolean compare(List<Integer> computer, List<Integer> number, Integer n) {
        System.out.println("볼: " + computer.indexOf(n) + number.indexOf(n));
        return computer.contains(n) && computer.indexOf(n) != number.indexOf(n);
    }
}
