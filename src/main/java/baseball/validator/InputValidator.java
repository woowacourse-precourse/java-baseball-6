package baseball.validator;

public class InputValidator {
    private static final String ZERO = "0";

    public void validate(String input, int size) {
        validateBlank(input);
        validateContainSpace(input);
        validateContainZero(input);
        validateLength(input, size);
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    private void validateContainSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("입력값에 공백이 포함되어 있습니다.");
        }
    }

    private void validateContainZero(String input) {
        if (input.contains(ZERO)) {
            throw new IllegalArgumentException("입력값에 0이 포함되어 있습니다.");
        }
    }

    private void validateLength(String input, int size) {
        if (input.length() != size) {
            throw new IllegalArgumentException(String.format("입력값은 %d자리여야 합니다.", size));
        }
    }
}
