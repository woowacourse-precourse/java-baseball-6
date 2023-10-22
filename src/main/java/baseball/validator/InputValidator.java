package baseball.validator;

import baseball.enums.GameConfig;

public class InputValidator {
    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private void validateLength(String input) {
        int ballCount = GameConfig.BALL_COUNT.getValue();
        if (input.length() != ballCount) {
            throw new IllegalArgumentException(String.format("입력값이 %d자리가 아닙니다.", ballCount));
        }
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

}
