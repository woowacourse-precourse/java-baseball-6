package baseball.domain;

import java.util.List;

public class ComputerNumbers {

    private final List<Integer> numbers;

    public ComputerNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void checkPlayerNumbers(List<Integer> playerNumbers, int digitNumber) {
        for (int pIndex = 0; pIndex < digitNumber; pIndex++) {
            int playerNumberOfIndex = playerNumbers.get(pIndex);
            for (int cIndex = 0; cIndex < digitNumber; cIndex++) {
                if (playerNumberOfIndex == numbers.get(cIndex)) {
                    if (pIndex == cIndex) {
                        BallCounter.countStrike();
                        continue;
                    }
                    BallCounter.countBall();
                }
            }
        }
    }
}
