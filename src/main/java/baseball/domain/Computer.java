package baseball.domain;

import static baseball.constant.BaseballConstant.BASEBALL_NUMBERS_SIZE;
import static baseball.constant.BaseballConstant.INVALID_INDEX;

public class Computer {

    private final String baseballNumber;

    public Computer(String baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public int countStrikes(String playerBaseballNumber) {
        int count = 0;

        for (int index = 0; index < BASEBALL_NUMBERS_SIZE; index++) {

            char targetNumber = playerBaseballNumber.charAt(index);

            if (isStrike(targetNumber, index)) {
                count += 1;
            }
        }

        return count;
    }

    public int countBalls(String playerBaseballNumber) {
        int count = 0;

        for (int index = 0; index < BASEBALL_NUMBERS_SIZE; index++) {

            int findIndex = findBaseballNumberIndex(playerBaseballNumber, index);

            if (isBall(findIndex, index)) {
                count += 1;
            }
        }

        return count;
    }

    private boolean isBall(int targetNumber, int index) {
        return targetNumber != INVALID_INDEX && targetNumber != index;
    }

    private boolean isStrike(int targetNumber, int index) {
        return targetNumber == this.baseballNumber.charAt(index);
    }

    private int findBaseballNumberIndex(String playerBaseballNumber, int index) {
        char targetNumber = playerBaseballNumber.charAt(index);
        return baseballNumber.indexOf(targetNumber);
    }
}
