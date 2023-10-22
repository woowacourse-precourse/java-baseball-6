package baseball.validator;

import baseball.enums.GameConfig;

public class InputValidator {
    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }
}
