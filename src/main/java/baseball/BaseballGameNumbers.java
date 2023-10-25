package baseball;

import java.util.List;

public class BaseballGameNumbers {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 10;
    private static final int NUMBER_SIZE = 3;
    private final RandomNumberPicker randomNumberPicker = new RandomNumberPicker();

    public Grader getRandomNumbersGrader() {
        return new Grader(randomNumberPicker.pickDistinctNumbersInRange(START_NUMBER,
            END_NUMBER, NUMBER_SIZE));
    }

    public void validatePlayerNumbers(List<Integer> playerNumbers) {
        if (NUMBER_SIZE != playerNumbers.size()) {
            throw new IllegalArgumentException();
        }

        int count = (int) playerNumbers.stream()
            .filter(number -> number >= START_NUMBER)
            .filter(number -> number < END_NUMBER)
            .count();

        if (NUMBER_SIZE != count) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumberSize() {
        return NUMBER_SIZE;
    }
}
