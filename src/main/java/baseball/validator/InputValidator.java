package baseball.validator;

import baseball.enums.GameConfig;

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
            throw new IllegalArgumentException(String.format("입력값이 %d자리가 아닙니다.", size));
        }
    }

    private void validateContinueNumber(String input) {
        int gameContinue = GameConfig.GAME_RESTART.getValue();
        int gameExit = GameConfig.GAME_EXIT.getValue();
        if (Integer.parseInt(input) != gameContinue && Integer.parseInt(input) != gameExit) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
