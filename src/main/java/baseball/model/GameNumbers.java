package baseball.model;

import java.util.List;

public class GameNumbers {
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;
    private static final int NUMBERS_SIZE = 3;

    private final List<Integer> numbers;

    public GameNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
