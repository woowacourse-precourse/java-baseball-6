package baseball.domain.ball;

import java.util.HashSet;
import java.util.List;

public abstract class BallNumbers {

    public static final int BALL_COUNT = 3;

    protected final List<BallNumber> ballNumbers;

    protected BallNumbers(final List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateDuplicateNumbers(numbers);
        this.ballNumbers = toBallNumberList(numbers);
    }

    private static List<BallNumber> toBallNumberList(final List<Integer> numbers) {
        return numbers.stream()
                .map(BallNumber::new)
                .toList();
    }

    private static void validateNumbersCount(final List<Integer> numbers) {
        if (numbers.size() != BALL_COUNT) {
            throw new IllegalArgumentException("BallNumbers는 3자리로 이루어진 숫자여야 합니다.");
        }
    }

    private static void validateDuplicateNumbers(final List<Integer> numbers) {
        final int size = new HashSet<>(numbers).size();
        if (size != BALL_COUNT) {
            throw new IllegalArgumentException("BallNumbers에 중복 숫자가 존재하면 안 됩니다.");
        }
    }

    protected BallNumber get(final int index) {
        return ballNumbers.get(index);
    }

}
