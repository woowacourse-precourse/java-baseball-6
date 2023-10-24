package baseball.domain;

import exception.DuplicateBaseBallNumber;
import exception.OutOfBaseBallNumbersSize;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class AnswerNumbers {

    public static final int MAX_BASE_BALL_SIZE = 3;
    public static final int MIN_BASE_BALL_NUMBER = 1;
    public static final int MAX_BASE_BALL_NUMBER = 9;

    private final List<Integer> values;

    private AnswerNumbers() {
        this.values = new ArrayList<>();
    }

    private AnswerNumbers(IntStream numbers) {
        this.values = new ArrayList<>();
        numbers.forEach(this::add);
    }

    public static AnswerNumbers empty() {
        return new AnswerNumbers();
    }

    public static AnswerNumbers of(String[] numbers) {
        IntStream numbersStream = Stream.of(numbers).mapToInt(Integer::parseInt);
        return new AnswerNumbers(numbersStream);
    }

    public int size() {
        return values.size();
    }

    public void add(int number) {
        validateDuplicate(number);
        validateNumberRange(number);
        validateNumbersSize();
        this.values.add(number);
    }

    public void validateDuplicate(int number) {
        if (this.values.contains(number)) {
            throw new DuplicateBaseBallNumber(String.format("Number %d already exists", number));
        }
    }

    public void validateNumbersSize() {
        if (this.size() >= MAX_BASE_BALL_SIZE) {
            throw new OutOfBaseBallNumbersSize(String.format("max size of baseball numbers is %d", MAX_BASE_BALL_SIZE));
        }
    }

    public void validateNumberRange(int number) {
        if (!isInBaseBallNumberRange(number)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private boolean isInBaseBallNumberRange(int number) {
        return number >= MIN_BASE_BALL_NUMBER && number <= MAX_BASE_BALL_NUMBER;
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
