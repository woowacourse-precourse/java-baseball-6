package baseball.domain;

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

    public static BaseBallNumbers emptyNumbers() {
        return new BaseBallNumbers(new ArrayList<>());
    }

    public int size() {
        return baseballNumbers.size();
    }

}
