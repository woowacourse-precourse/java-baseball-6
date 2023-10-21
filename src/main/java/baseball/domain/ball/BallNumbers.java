package baseball.domain.ball;

import java.util.ArrayList;
import java.util.List;

public abstract class BallNumbers {


    public static final int BALL_COUNT = 3;

    protected final List<BallNumber> ballNumbers;

    protected BallNumbers(final List<Integer> numbers) {
        validateNumbersCount(numbers);
        this.ballNumbers = intoBallNumberList(numbers);
    }

    private static List<BallNumber> intoBallNumberList(final List<Integer> numbers) {
        final List<BallNumber> ballNumbers = new ArrayList<>();

        for (final Integer number : numbers) {
            ballNumbers.add(new BallNumber(number));
        }
        return ballNumbers;
    }

    private static void validateNumbersCount(final List<Integer> numbers) {
        if (numbers.size() != BALL_COUNT) {
            throw new IllegalArgumentException("BallNumbers는 3자리로 이루어진 숫자여야 합니다.");
        }
    }

    protected BallNumber get(final int index) {
        return ballNumbers.get(index);
    }
}
