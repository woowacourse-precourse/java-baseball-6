package baseball.games.numberbaseball.validation;

public class BaseballValidator {
    private static final Integer NUMBERS_INPUT_SIZE = 3;
    private static final Character NUMBERS_RANGE_START = '1';
    private static final Character NUMBERS_RANGE_END = '9';

    private boolean isInvalidNumbersLength(String input) {
        return input.length() != NUMBERS_INPUT_SIZE;
    }

    private boolean containsOutRangeInput(String input) {
        return input.chars()
                .anyMatch(c -> c < NUMBERS_RANGE_START || c > NUMBERS_RANGE_END);
    }
}
