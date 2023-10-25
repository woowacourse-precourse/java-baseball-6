package baseball.validation;

import java.util.List;
import java.util.stream.Stream;

public class NumberValidation {
    public static final String ERROR_GAP = "[ERROR] 공백 없이 입력해주세요.";

    public static final String ERROR_LENGTH = "[ERROR] 길이를 3으로 입력해주세요.";

    public static final String ERROR_NOT_NUMBER = "[ERROR] 숫자만 입력해주세요.";

    public static final String ERROR_RANGE = "[ERROR] 1~9 사이의 숫자만 입력해주세요.";

    public static final String ERROR_DUPLICATE = "[ERROR] 중복 되지 않게 숫자를 입력해주세요.";

    public static final String ERROR_NOT_PERMITTED = "[ERROR] 1 또는 2를 입력해주세요.";

    public void validateAll(String userInput) {
        validateGap(userInput);
        validateLength(userInput);
        validateNumber(userInput);
        validateRange(userInput);
        validateDuplicate(userInput);
    }

    // 공백이 있는 경우
    public void validateGap(String userInput) {
        if (userInput.contains(" ")) {
            throw new IllegalArgumentException(ERROR_GAP);
        }
    }

    // 길이가 3이 아닌 경우
    public void validateLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
    }

    // 숫자가 아닌 경우
    public void validateNumber(String userInput) {
        if (!userInput.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    // 1~9 사이의 수가 아닌 경우
    public void validateRange(String userInput) {
        if (userInput.contains("0")) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    // 숫자가 중복된 경우
    public void validateDuplicate(String userInput) {
        if (Stream.of(userInput.split("")).distinct().count() != userInput.length()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    // 1 또는 2가 아닌 경우
    public void validateRestartOrEnd(String userInput) {
        if (!userInput.matches("[1-2]")) {
            throw new IllegalArgumentException(ERROR_NOT_PERMITTED);
        }
    }
}
