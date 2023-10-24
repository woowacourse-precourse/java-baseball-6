package baseball.utils;

public class InputValidator {
    private final String RETRY_REGEX = "[1-2]+";
    private final String USER_INPUT_REGEX = "[1-9]+";

    public void checkUserInput(String userInput) {
        checkLength(userInput);
        checkDigit(userInput);
    }

    public void checkRetryInput(String userInput) {
        if (!userInput.matches(RETRY_REGEX)) {
            throw new IllegalArgumentException("1 또는 2만 입력해주세요.");
        }
    }

    void checkLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리 수를 입력해주세요.");
        }
    }

    void checkDigit(String userInput) {
        if (!userInput.matches(USER_INPUT_REGEX)) {
            throw new IllegalArgumentException("모든 자릿수를 서로 다른 수로 입력해주세요.");
        }
    }
}
