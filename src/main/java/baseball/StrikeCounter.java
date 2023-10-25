package baseball;

import java.util.List;

public class StrikeCounter implements Counter {
    public int judge(List<Integer> computer, List<Integer> number) {
        return (int) number.stream()
                .filter(n -> compare(computer, number, n))
                .count();
    }

    private boolean compare(List<Integer> computer, List<Integer> number, Integer n) {
        System.out.println("스트라이크: " + computer.indexOf(n) + number.indexOf(n));
        return computer.indexOf(n) == number.indexOf(n);
    }
}
