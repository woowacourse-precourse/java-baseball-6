package baseball;

import java.util.List;

public class StrikeCounter implements Counter {
    public int judge(List<Integer> computer, List<Integer> number) {
        return (int) number.stream()
                .filter(n -> isStrike(computer, number, n))
                .count();
    }

    private boolean isStrike(List<Integer> computer, List<Integer> number, Integer n) {
        System.out.println("스트라이크: " + computer.indexOf(n) + number.indexOf(n));
        return computer.indexOf(n) == number.indexOf(n);
    }
}
