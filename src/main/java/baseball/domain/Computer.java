package baseball.domain;

import static baseball.game.BaseballConstant.BASEBALL_NUMBERS_SIZE;
import static baseball.game.BaseballConstant.INVALID_INDEX;

public class Computer {

    private final String baseballNumber;

    public Computer(String baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public int countStrikes(String player) {
        int count = 0;

        for (int i = 0; i < BASEBALL_NUMBERS_SIZE; i++) {
            char targetNumber = player.charAt(i);

            if (isStrike(targetNumber, i)) {
                count += 1;
            }
        }

        return count;
    }

    public int countBalls(String player) {
        int count = 0;

        for (int i = 0; i < BASEBALL_NUMBERS_SIZE; i++) {
            int findIndex = findNumberIndex(player, i);

            if (isBall(findIndex, i)) {
                count += 1;
            }
        }

        return count;
    }

    private boolean isBall(int target, int i) {
        return target != INVALID_INDEX && target != i;
    }

    private boolean isStrike(int target, int i) {
        return target == baseballNumber.charAt(i);
    }

    private int findNumberIndex(String player, int i) {
        char targetNumber = player.charAt(i);
        return baseballNumber.indexOf(targetNumber);
    }
}
