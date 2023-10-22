package baseball.domain;

import exception.DuplicateBaseBallNumber;
import exception.OutOfBaseBallNumbersSize;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class BaseBallNumbers {

    public static final int MAX_BASE_BALL_SIZE = 3;
    public static final int MIN_BASE_BALL_NUMBER = 1;
    public static final int MAX_BASE_BALL_NUMBER = 9;

    private final List<Integer> baseballNumbers;

    private BaseBallNumbers(List<Integer> numbers) {
        this.baseballNumbers = numbers;
    }

    private BaseBallNumbers(IntStream numbers) {
        this.baseballNumbers = new ArrayList<>();
        numbers.forEach(this::add);
    }

    public static BaseBallNumbers empty() {
        return new BaseBallNumbers(new ArrayList<>());
    }

    public static BaseBallNumbers of(IntStream numbers) {
        return new BaseBallNumbers(numbers);
    }

    public int size() {
        return baseballNumbers.size();
    }

    public void add(int number) {
        validateDuplicate(number);
        validateNumberRange(number);
        validateNumbersSize();
        baseballNumbers.add(number);
    }

    public void validateDuplicate(int number) {
        if (baseballNumbers.contains(number)) {
            throw new DuplicateBaseBallNumber(String.format("Number %d already exists", number));
        }
    }

    public void validateNumbersSize() {
        if (this.size() >= MAX_BASE_BALL_SIZE) {
            throw new OutOfBaseBallNumbersSize(String.format("max size of baseball numbers is %d", MAX_BASE_BALL_SIZE));
        }
    }

    public void validateNumberRange(int number) {
        if (isInBaseBallNumberRange(number)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private boolean isInBaseBallNumberRange(int number) {
        return number >= MIN_BASE_BALL_NUMBER && number <= MAX_BASE_BALL_NUMBER;
    }

    public List<Integer> get() {
        return baseballNumbers;
    }

    public boolean isBall(int number) {
        return baseballNumbers.contains(number);
    }

    public boolean isStrike(int number, int index) {
        return baseballNumbers.get(index) == number;
    }
}
