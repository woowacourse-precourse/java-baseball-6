package baseball;

import java.util.List;
import java.util.Objects;

public class CalculateResult {
    private final List<Integer> inputNumberList;
    private final List<Integer> randomNumberList;

    public CalculateResult(List<Integer> inputNumberList, List<Integer> randomNumberList) {
        this.inputNumberList = inputNumberList;
        this.randomNumberList = randomNumberList;
    }

    public int calculateStrikes() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(inputNumberList.get(i), randomNumberList.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int calculateBalls() {
        int count = 0;
        for (Integer number : inputNumberList) {
            if (randomNumberList.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
