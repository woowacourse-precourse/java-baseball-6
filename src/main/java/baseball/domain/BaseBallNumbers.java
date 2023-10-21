package baseball.domain;

import exception.DuplicateBaseBallNumber;
import exception.OutOfBaseBallNumbersSize;
import java.util.ArrayList;
import java.util.List;

public final class BaseBallNumbers {

    public static final int MAX_BASE_BALL_SIZE = 3;
    public static final int MIN_BASE_BALL_NUMBER = 1;
    public static final int MAX_BASE_BALL_NUMBER = 9;

    private final List<Integer> baseballNumbers;

    private BaseBallNumbers(List<Integer> numbers) {
        this.baseballNumbers = numbers;
    }

    public static BaseBallNumbers empty() {
        return new BaseBallNumbers(new ArrayList<>());
    }

    public int size() {
        return baseballNumbers.size();
    }

    public void add(int number) {
        validateDuplicate(number);
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
}
