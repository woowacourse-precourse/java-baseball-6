package baseball;

public class InputValidator {

    private static final String VALID_RETRY_INPUT_PATTERN = "[12]";

    public void validateGuessNumbers(String input) {
        validateNumeric(input);
        validateLength(input);
        validateNoDuplicated(input);
    }

    public void validateRetryNumber(String input) {
        validateOneOrTwo(input);
    }

    private void validateNumeric(String input) {
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException("숫자가 아닌 다른 문자가 포함되어 있습니다.");
        }
    }

    private void validateLength(String input) {
        if (input.length() != GameConstants.NUM_DIGITS) {
            throw new IllegalArgumentException(GameConstants.NUM_DIGITS + "자리의 숫자가 아닙니다.");
        }
    }

    private void validateNoDuplicated(String input) {
        if (input.chars()
                .distinct()
                .count() != GameConstants.NUM_DIGITS) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해야됩니다.");
        }
    }

    private void validateOneOrTwo(String input) {
        if (!input.matches(VALID_RETRY_INPUT_PATTERN)) {
            throw new IllegalArgumentException(
                    "숫자 " + GameConstants.RETRY_CHOICE + " 또는 " + GameConstants.EXIT_CHOICE + "를 입력해야됩니다.");
        }
    }
}

