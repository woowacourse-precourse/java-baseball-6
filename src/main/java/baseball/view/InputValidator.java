package baseball.view;

public class InputValidator {

    private static final String EMPTY_INPUT_MESSAGE = "입력이 비어 있습니다.";

    public void validateInput(final String input) {
        if (isInvalidInput(input)) {
            throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
        }
    }

    private boolean isInvalidInput(final String input) {
        return input == null || input.isBlank();
    }
}
