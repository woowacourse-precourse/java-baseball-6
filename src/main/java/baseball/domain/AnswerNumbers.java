package baseball.domain;

import exception.OutOfBaseBallNumbersSize;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class AnswerNumbers {

    public static final int MAX_BASE_BALL_SIZE = 3;
    public static final int MIN_BASE_BALL_NUMBER = 1;
    public static final int MAX_BASE_BALL_NUMBER = 9;

    private final List<Integer> values;

    private AnswerNumbers(List<Integer> numbers) {
        final List<Integer> answerNumbers = numbers.stream()
                .peek(this::validateNumberRange)
                .distinct()
                .toList();
        validateNumbersSize(numbers);
        this.values = answerNumbers;
    }

    public static AnswerNumbers of(List<Integer> numbers) {
        return new AnswerNumbers(numbers);
    }

    public static AnswerNumbers of(String[] numbers) {
        List<Integer> numbersStream = Stream.of(numbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
        return new AnswerNumbers(numbersStream);
    }

    public int size() {
        return values.size();
    }

    public void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != MAX_BASE_BALL_SIZE) {
            throw new OutOfBaseBallNumbersSize(String.format("max size of baseball numbers is %d", MAX_BASE_BALL_SIZE));
        }
    }

    public void validateNumberRange(int number) {
        if (!isInBaseBallNumberRange(number)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private boolean isInBaseBallNumberRange(int number) {
        return IntStream.range(MIN_BASE_BALL_NUMBER, MAX_BASE_BALL_NUMBER + 1)
                .boxed()
                .toList()
                .contains(number);
    }

    public int countBallOf(AnswerNumbers numbers) {
        return (int) values.stream()
                .filter(numbers::isBall)
                .count();
    }

    public int countStrikeOf(AnswerNumbers numbers) {
        return (int) IntStream.range(0, values.size())
                .filter(index -> numbers.isStrike(values.get(index), index))
                .count();
    }

    public boolean isBall(int number) {
        return values.contains(number);
    }

    public boolean isStrike(int number, int index) {
        return values.get(index) == number;
    }
}
