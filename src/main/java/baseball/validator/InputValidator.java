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

    private void validateRange(int number) {
        int minNumber = GameConfig.MIN_NUMBER.getValue();
        int maxNumber = GameConfig.MAX_NUMBER.getValue();
        if (number < minNumber || number > maxNumber) {
            throw new IllegalArgumentException(String.format("입력값이 %d~%d 사이의 값이 아닙니다.", minNumber, maxNumber));
        }
    }

    private void validateDuplicate(String input) {
        int ballCount = GameConfig.BALL_COUNT.getValue();
        for (int i = 0; i < ballCount; i++) {
            for (int j = i + 1; j < ballCount; j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    throw new IllegalArgumentException("중복된 숫자가 있습니다.");
                }
            }
        }
    }
}
