package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballResult;
import baseball.domain.Ball;
import baseball.domain.Strike;
import baseball.util.BaseballNumberGenerator;

public class BaseballService {
    private static final int INITIAL_INDEX = 0;
    private static final int NUMBERS_SIZE = 3;
    private final BaseballNumberGenerator baseballNumberGenerator;

    public BaseballService() {
        this.baseballNumberGenerator = new BaseballNumberGenerator();
    }

    public BaseballNumber generateRandomNumbers() {
        return baseballNumberGenerator.generate();
    }

    public BaseballResult calculateResult(BaseballNumber computerNumber, BaseballNumber playerNumber) {
        int strikes = countStrikes(computerNumber, playerNumber);
        int balls = countBalls(computerNumber, playerNumber);

        return new BaseballResult(Strike.fromInt(strikes), Ball.fromInt(balls));
    }

    private int countStrikes(BaseballNumber computerNumber, BaseballNumber playerNumber) {
        int strikes = 0;
        for (int position = INITIAL_INDEX; position < NUMBERS_SIZE; position++) {
            if (isStrike(computerNumber, playerNumber, position)) {
                strikes++;
            }
        }
        return strikes;
    }

    private int countBalls(BaseballNumber computerNumber, BaseballNumber playerNumber) {
        int balls = 0;
        for (int position = 0; position < 3; position++) {
            if (!isStrike(computerNumber, playerNumber, position) &&
                    isBall(computerNumber, playerNumber, position)) {
                balls++;
            }
        }
        return balls;
    }

    private boolean isStrike(BaseballNumber computerNumber, BaseballNumber playerNumber, int position) {
        return computerNumber.matchesAtPosition(playerNumber.getNumberAtPosition(position), position);
    }

    private boolean isBall(BaseballNumber computerNumber, BaseballNumber playerNumber, int position) {
        return computerNumber.hasNumber(playerNumber.getNumberAtPosition(position));
    }

}
