package baseball.view;

public class InputValidation {

    private static final String INVALID_INPUT_MESSAGE = "입력이 비어있습니다.";

    public void validate(final String input) {
        if (isWrongInput(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private boolean isWrongInput(final String input) {
        return input == null || input.isBlank();
    }
}
