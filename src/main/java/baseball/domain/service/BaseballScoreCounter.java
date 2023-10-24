package baseball.domain.service;

import java.util.stream.IntStream;

public class BaseballScoreCounter {
    private final String inputNumber;
    private final String targetNumber;

    public BaseballScoreCounter(String inputNumber, String targetNumber) {
        this.inputNumber = inputNumber;
        this.targetNumber = targetNumber;
    }

    public int countStrikes() {
        int strikes = 0;
        for (int i = 0; i < targetNumber.length(); i++) {
            if (targetNumber.charAt(i) == inputNumber.charAt(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    public int countBalls() {
        return (int) IntStream.range(0, inputNumber.length())
                .filter(this::isBall)
                .count();
    }

    private boolean isBall(int i) {
        return targetNumber.indexOf(inputNumber.charAt(i)) != -1
                && targetNumber.charAt(i) != inputNumber.charAt(i);
    }

    public boolean isNoHit() {
        return countStrikes() == 0 && countBalls() == 0;
    }
}

