package baseball.view;

import baseball.exception.BaseballGameException;

public class InputValidator {
    private InputValidator() {
    }

    public static void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new BaseballGameException("입력한 값이 null 혹은 빈값입니다.");
        }
    }
}
