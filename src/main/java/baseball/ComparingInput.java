package baseball;

import java.util.ArrayList;
import java.util.List;

public class ComparingInput {
    private final List<Integer> answer;
    private final int digits;

    public ComparingInput(List<Integer> answer, int digits) {
        this.answer = answer;
        this.digits = digits;
    }

    public List<Integer> countMatch(List<Integer> input) {
        List<Integer> ballCount = new ArrayList<>(List.of(0, 0));
        for (int digit = 0; digit < digits; digit++) {
            if (input.get(digit).equals(answer.get(digit))) {
                ballCount.set(1, ballCount.get(1) + 1);
            }
            else if (answer.contains(input.get(digit))) {
                ballCount.set(0, ballCount.get(0) + 1);
            }
        }
        return ballCount;
    }
}
