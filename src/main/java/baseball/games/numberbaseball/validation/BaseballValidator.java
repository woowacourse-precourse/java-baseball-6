package baseball.games.numberbaseball.validation;

public class BaseballValidator {
    private static final Integer NUMBERS_INPUT_SIZE = 3;

    private boolean isInvalidNumbersLength(String input) {
        return input.length() != NUMBERS_INPUT_SIZE;
    }
}
