package baseball.validator;

import baseball.enums.GameConfig;

public class InputValidator {
    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private void validateLength(String input) {
        int pitchCount = GameConfig.PITCH_COUNT.getValue();
        if (input.length() != pitchCount) {
            throw new IllegalArgumentException(String.format("입력값이 %d자리가 아닙니다.", pitchCount));
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
        int pitchCount = GameConfig.PITCH_COUNT.getValue();
        for (int i = 0; i < pitchCount; i++) {
            for (int j = i + 1; j < pitchCount; j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    throw new IllegalArgumentException("중복된 숫자가 있습니다.");
                }
            }
        }
    }

    private void validateContinueNumber(String input) {
        int gameContinue = GameConfig.GAME_CONTINUE.getValue();
        int gameExit = GameConfig.GAME_EXIT.getValue();
        if (Integer.parseInt(input) != gameContinue && Integer.parseInt(input) != gameExit) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
