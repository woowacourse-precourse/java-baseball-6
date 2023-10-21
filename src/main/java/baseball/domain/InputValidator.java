package baseball.domain;

import baseball.constant.GameCommand;
import baseball.constant.GameConstants;

public class InputValidator {
    public static void validateDigitCount(String input) throws IllegalArgumentException {
        if (input == null || input.length() != GameConstants.FIXED_DIGIT_NUMBER || !input.matches("\\d+")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    public static void validateCommand(String input) throws IllegalArgumentException {
        if (!input.equals(GameCommand.GAME_RESTART_COMMAND) && !input.equals(GameCommand.GAME_OVER_COMMAND)) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
