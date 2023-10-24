package baseball.controller;

import baseball.enums.ErrorCode;

public class InputValidator {

    public static void validatePlayerNumber(String playerNumber) {
        if (playerNumber.length() != 3) {
            throw new IllegalArgumentException(ErrorCode.WRONG_LENGTH.getMessage());
        }
        if (playerNumber.chars().distinct().count() != 3) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
        }
        if (!playerNumber.matches("[1-9]{3}")) {
            throw new IllegalArgumentException(ErrorCode.OUT_OF_RANGE.getMessage());
        }
    }

    public static void validateGameChoice(String choice) {
        if (!"1".equals(choice) && !"2".equals(choice)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_GAME_CHOICE.getMessage());
        }
    }
}
