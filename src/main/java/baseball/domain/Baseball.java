package baseball.domain;

import baseball.common.config.BaseballSystemConst;
import java.util.List;

public class Baseball {
    private List<Integer> numbers;

    public Baseball(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public BaseballResult compareTo(Baseball other) {
        int containsBall = calculateContainsBall(other);
        int sameBall = calculateSameBall(other);
        return BaseballResult.from(containsBall - sameBall, sameBall);
    }

    private int calculateContainsBall(Baseball other) {
        int result = 0;
        for (int number : other.numbers) {
            if (this.numbers.contains(number)) {
                result++;
            }
        }
        return result;
    }

    private int calculateSameBall(Baseball other) {
        int result = 0;
        for (int i = 0; i < BaseballSystemConst.MAX_BALL_SIZE; i++) {
            if (this.numbers.get(i) == other.numbers.get(i)) {
                result++;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Baseball : ");
        for (int number : numbers) {
            sb.append(number + " ");
        }
        return sb.toString();
    }
}
