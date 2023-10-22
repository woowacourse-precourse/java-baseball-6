package baseball.domain;

import baseball.util.GameCommand;
import baseball.util.GameConstants;

public class InputValidator {
    public static void validateDigitCount(String input) throws IllegalArgumentException {
        if (input == null || input.length() != GameConstants.FIXED_DIGIT_NUMBER || !input.matches("\\d+")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    public static void validateCommand(GameCommand gameCommand) throws IllegalArgumentException {
        if (gameCommand == GameCommand.UNKNOWN_COMMAND) {
            throw new IllegalArgumentException("잘못된 커맨드를 입력하셨습니다.");
        }
    }
}
