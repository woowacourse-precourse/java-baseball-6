package baseball.domain;

import static baseball.constant.Constant.BASEBALL_GAME_NUMBER_DIGIT;

import baseball.domain.dto.GuessNumberResultResponse;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int THREE_STRIKE = 3;
    private static final int ONE_STRIKE = 1;
    private static final int ONE_BALL = 1;
    private static final int NO_STRIKE = 0;
    private static final int NO_BALL = 0;
    private static final String NOTHING = "낫싱";

    private List<Integer> numbers;
    private boolean threeStrike;

    public GuessNumberResultResponse calculateGuessNumberResult(final List<Integer> guessNumbers) {
        int ballCount = NO_BALL;
        int strikeCount = NO_STRIKE;
        for (int index = 0; index < BASEBALL_GAME_NUMBER_DIGIT; index++) {
            ballCount += calculateBall(getList(), guessNumbers.get(index), index);
            strikeCount += calculateStrike(getList().get(index), guessNumbers.get(index));
        }
        checkThreeStrike(strikeCount);
        return conditionalResult(strikeCount, ballCount);
    }

    private int calculateBall(final List<Integer> computerNumber, final int guessNumber, final int index) {
        if (isBall(computerNumber, guessNumber, index)) {
            return ONE_BALL;
        }
        return NO_BALL;
    }

    private boolean isBall(final List<Integer> computerNumber, final int guessNumber, final int index) {
        return computerNumber.contains(guessNumber) && computerNumber.get(index) != guessNumber;
    }

    private int calculateStrike(final int computerNumber, final int guessNumber) {
        if (isStrike(computerNumber, guessNumber)) {
            return ONE_STRIKE;
        }
        return NO_STRIKE;
    }

    private boolean isStrike(int computerNumber, int guessNumber) {
        return computerNumber == guessNumber;
    }

    private void checkThreeStrike(final int strikeCount) {
        if (isThreeStrike(strikeCount)) {
            threeStrike = true;
        }
    }

    private boolean isThreeStrike(final int strikeCount) {
        return strikeCount == THREE_STRIKE;
    }

    private GuessNumberResultResponse conditionalResult(final int strikeCount, final int ballCount) {
        if (isNothing(strikeCount, ballCount)) {
            return GuessNumberResultResponse.from(NOTHING);
        }
        return GuessNumberResultResponse.of(ballCount, strikeCount);
    }

    private boolean isNothing(final int strikeCount, final int ballCount) {
        return strikeCount == NO_STRIKE && ballCount == NO_BALL;
    }

    private List<Integer> getList() {
        if (numbers == null) {
            numbers = new ArrayList<>();
            createNumbers();
        }
        return numbers;
    }

    private void createNumbers() {
        BaseBallGameNumberGenerator baseBallGameNumberGenerator = new BaseBallGameNumberGenerator();
        numbers = baseBallGameNumberGenerator.generateNumbers();
    }

    public boolean isGameOver() {
        return threeStrike;
    }

    public void end() {
        numbers = null;
        threeStrike = false;
    }
}
