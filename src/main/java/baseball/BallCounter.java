package baseball;

import java.util.List;

public class BallCounter {
    public int judge(List<Integer> computer, List<Integer> number) {
        return (int) number.stream()
                .filter(n -> isBall(computer, number, n))
                .count();
    }

    private boolean isBall(List<Integer> computer, List<Integer> number, Integer n) {
        System.out.println("볼: " + computer.indexOf(n) + number.indexOf(n));
        return computer.contains(n) && computer.indexOf(n) != number.indexOf(n);
    }
}
