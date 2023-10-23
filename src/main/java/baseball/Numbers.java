package baseball;

import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Score calculateScore(Numbers other) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < numbers.size(); i++) {
            int myNumber = this.numbers.get(i);
            int otherNumber = other.numbers.get(i);
            if (myNumber == otherNumber) {
                strike++;
            } else if (this.numbers.contains(otherNumber)) {
                ball++;
            }
        }
        return new Score(strike, ball);
    }
}
