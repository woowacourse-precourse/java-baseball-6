package baseball;

public class Validator {
    private final String EMPTY_VALUE_ERROR_MESSAGE = "빈 값은 입력할 수 없습니다.";
    private final String LENGTH_ERROR_MESSAGE = "세 자리 이외의 값은 입력할 수 없습니다.";
    private final String TYPE_ERROR_MESSAGE = "숫자 이외의 값은 입력할 수 없습니다.";
    private final String CONTAIN_ZERO_ERROR_MESSAGE = "0은 입력할 수 없습니다.";
    private final String RESTART_INPUT_ERROR_MESSAGE = "1과 2 이외의 숫자는 입력할 수 없습니다.";

    private final Integer CORRECT_LENGTH = 3;
    private final String RESTART_NUMBER = "1";
    private final String EXIT_NUMBER = "2";
    private final String ZERO = "0";
    private final String VALID_NUMBER_REGEX = "^[0-9]*$";

    public void validateNumberInput(String input) {
        if (isEmptyValue(input)) {
            throw new IllegalArgumentException(EMPTY_VALUE_ERROR_MESSAGE);
        }
        if (!isCorrectLength(input)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
        if (!isNumberType(input)) {
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
        }
        if (isContainingZero(input)) {
            throw new IllegalArgumentException(CONTAIN_ZERO_ERROR_MESSAGE);
        }
    }

    public void validateRestartInput(String input) {
        if (isNotOneOrTwo(input)) {
            throw new IllegalArgumentException(RESTART_INPUT_ERROR_MESSAGE);
        }
    }

    public boolean isNotOneOrTwo(String input) {
        return !input.equals(RESTART_NUMBER) && !input.equals(EXIT_NUMBER);
    }

    private boolean isContainingZero(String input) {
        return input.contains(ZERO);
    }

    private boolean isCorrectLength(String input) {
        return input.length() == CORRECT_LENGTH;
    }

    private boolean isEmptyValue(String input) {
        return input.isBlank();
    }

    private boolean isNumberType(String input) {
        return input.matches(VALID_NUMBER_REGEX);
    }
}
