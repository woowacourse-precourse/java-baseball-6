package baseball.domain;

import baseball.global.util.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public Computer() {
        this.numbers = new ArrayList<>();
    }

    public void generate() {
        numbers = RandomNumberGenerator.generateRandomNumber();
    }

    public HintResult generateHintResult(Numbers givenNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == givenNumbers.get(i)) {
                strike++;
            }
            ball += isBallIndex(i, givenNumbers);
        }
        return new HintResult(strike, ball);
    }

    private int isBallIndex(int i, Numbers givenNumbers) {
        for (int j = 0; j < givenNumbers.size(); j++) {
            if (i != j && numbers.get(i) == givenNumbers.get(j)) {
                return 1;
            }
        }
        return 0;
    }
}
