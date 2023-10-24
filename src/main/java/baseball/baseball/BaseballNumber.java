package baseball.baseball;

import java.util.List;
import java.util.Objects;

public class BaseballNumber {

    private final List<Integer> numbers;

    public BaseballNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int countStrike(BaseballNumber otherBaseballNumber) {
        List<Integer> otherNumbers = otherBaseballNumber.numbers;
        int numStrike = 0;
        for (int idx = 0; idx < 3; ++idx) {
            if (Objects.equals(otherNumbers.get(idx), numbers.get(idx))) {
                numStrike++;
            }
        }

        return numStrike;
    }

    public int countBall(BaseballNumber otherBaseballNumber) {
        List<Integer> otherNumbers = otherBaseballNumber.numbers;
        int numBall = 0;
        for (int idx = 0; idx < 3; ++idx) {
            int index = otherNumbers.indexOf(numbers.get(idx));
            if (index != -1 && idx != index) {
                numBall++;
            }
        }

        return numBall;
    }
}
