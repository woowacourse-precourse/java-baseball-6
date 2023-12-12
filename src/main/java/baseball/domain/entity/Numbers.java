package baseball.domain.entity;

import static baseball.utils.constants.IntegerConstants.*;

import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers of(List<Integer> numbers) {
        return new Numbers(numbers);
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }

    public int matchStrike(Numbers computerNumbers) {
        int strike = 0;
        for (int i = 0; i < NUMBERS_SIZE.getValue(); i++) {
            if (this.numbers.get(i) == computerNumbers.getNumber(i)) {
	strike++;
            }
        }
        return strike;
    }

    public int matchBall(Numbers computerNumbers) {
        int ball = 0;
        for (int i = 0; i < NUMBERS_SIZE.getValue(); i++) {
            for (int j = i; j < NUMBERS_SIZE.getValue(); j++) {
	if (i == j) {
	    continue;
	}
	if (this.numbers.get(i) == computerNumbers.getNumber(j)) {
	    ball++;
	}
            }
        }
        return ball;
    }
}
