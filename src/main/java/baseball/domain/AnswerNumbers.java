package baseball.domain;

import exception.OutOfBaseBallNumbersSize;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class AnswerNumbers {

    public static final int MAX_BASE_BALL_SIZE = 3;
    public static final int MIN_BASE_BALL_NUMBER = 1;
    public static final int MAX_BASE_BALL_NUMBER = 9;

    private final List<Integer> values;

    private AnswerNumbers(Set<Integer> numbers) {
        validateNumbersSize(numbers);
        this.values = numbers.stream()
                .peek(this::validateNumberRange)
                .toList();
    }

    public static AnswerNumbers of(Set<Integer> numbers) {
        return new AnswerNumbers(numbers);
    }

    public static AnswerNumbers of(String[] numbers) {
        Set<Integer> numbersStream = Stream.of(numbers)
                .mapToInt(Integer::parseInt)
                .distinct()
                .boxed()
                .collect(Collectors.toSet());
        return new AnswerNumbers(numbersStream);
    }

    public int size() {
        return values.size();
    }

    public void validateNumbersSize(Set<Integer> numbers) {
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
        return IntStream.range(MIN_BASE_BALL_NUMBER, MAX_BASE_BALL_NUMBER)
                .boxed()
                .toList()
                .contains(number);
    }

    public int count(Predicate<Integer> predicate) {
        return (int) values.stream()
                .filter(predicate)
                .count();
    }

    public int countWithIndex(BiPredicate<Integer, Integer> biPredicate) {
        return (int) IntStream.range(0, values.size())
                .filter(index -> biPredicate.test(values.get(index), index))
                .count();
    }

    public boolean isBall(int number) {
        return values.contains(number);
    }

    public boolean isStrike(int number, int index) {
        return values.get(index) == number;
    }
}
