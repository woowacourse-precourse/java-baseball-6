package baseball.domain;

import static baseball.util.Constant.BASEBALL_GAME_NUMBER_DIGIT;

import java.util.List;

public class Referee {

    private static final int ONE_STRIKE = 1;
    private static final int ONE_BALL = 1;
    private static final int NO_STRIKE = 0;
    private static final int NO_BALL = 0;
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String BLANK = " ";
    private static final String THREE_STRIKE = "0볼 3스트라이크";

    private final Computer computer;

    public Referee(final Computer computer) {
        this.computer = computer;
    }

    public String calculateResult(final List<Integer> guessNumbers) {
        int ballCount = NO_BALL;
        int strikeCount = NO_STRIKE;
        for (int index = 0; index < BASEBALL_GAME_NUMBER_DIGIT.getValue(); index++) {
            if (computer.isExistNumber(guessNumbers.get(index))) {
                ballCount += checkBall(guessNumbers.get(index), index);
                strikeCount += checkStrike(guessNumbers.get(index), index);
            }
        }
        return makeResult(ballCount, strikeCount);
    }

    private int checkBall(final int guessNumber, final int index) {
        if (computer.isBall(guessNumber, index)) {
            return ONE_BALL;
        }
        return NO_BALL;
    }

    private int checkStrike(final int guessNumber, final int index) {
        if (computer.isStrike(guessNumber, index)) {
            return ONE_STRIKE;
        }
        return NO_STRIKE;
    }

    private String makeResult(final int ballCount, final int strikeCount) {
        if (isNothing(ballCount, strikeCount)) {
            return NOTHING;
        }
        return ballCount + BALL + BLANK + strikeCount + STRIKE;
    }

    private boolean isNothing(final int ballCount, final int strikeCount) {
        return ballCount == NO_BALL && strikeCount == NO_STRIKE;
    }

    public boolean isGameOver(final String result) {
        return result.equals(THREE_STRIKE);
    }
}
