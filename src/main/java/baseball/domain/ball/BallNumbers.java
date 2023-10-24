package baseball.domain.ball;

import baseball.exception.DuplicateBallNumbersException;
import collection.Triple;

public abstract class BallNumbers {

    public static final int BALL_COUNT = 3;

    protected final Triple<BallNumber> ballNumbers;

    protected BallNumbers(final Triple<BallNumber> ballNumbers) {
        validateDuplicateNumbers(ballNumbers);
        this.ballNumbers = ballNumbers;
    }

    private static void validateDuplicateNumbers(final Triple<BallNumber> numbers) {
        final int size = numbers.toSet().size();
        if (size != BALL_COUNT) {
            throw new DuplicateBallNumbersException();
        }
    }

    protected BallNumber get(final int index) {
        return ballNumbers.get(index);
    }

}
