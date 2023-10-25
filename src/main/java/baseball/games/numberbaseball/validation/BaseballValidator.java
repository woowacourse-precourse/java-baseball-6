package baseball.games.numberbaseball.validation;

public class BaseballValidator {
    private static final Integer NUMBERS_INPUT_SIZE = 3;
    private static final Character NUMBERS_RANGE_START = '1';
    private static final Character NUMBERS_RANGE_END = '9';
    private static final Integer OPTION_INPUT_SIZE = 1;
    private static final Character RESTART = '1';
    private static final Character END = '2';

    public void validateNumbersInput(String input) {
        if (isInvalidNumbersLength(input)) {
            throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
        }
        if (containsOutRangeInput(input)) {
            throw new IllegalArgumentException("모든 입력은 1에서 9까지의 숫자만 입력이 가능합니다.");
        }
        if (containsDuplicatedInput(input)) {
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
        }
    }

    private boolean isInvalidNumbersLength(String input) {
        return input.length() != NUMBERS_INPUT_SIZE;
    }

    private boolean containsOutRangeInput(String input) {
        return input.chars()
                .anyMatch(c -> c < NUMBERS_RANGE_START || c > NUMBERS_RANGE_END);
    }

    private boolean containsDuplicatedInput(String input) {
        return input.chars()
                .distinct()
                .count() < NUMBERS_INPUT_SIZE;
    }

    private boolean isInvalidOptionLength(String input) {
        return input.length() != OPTION_INPUT_SIZE;
    }

    private boolean containsNotOption(String input) {
        char playerOption = input.charAt(0);
        return playerOption != RESTART && playerOption != END;
    }
}
