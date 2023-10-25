package baseball.controller;

import baseball.enums.ErrorCode;

public class InputValidator {
    private static final int VALID_NUMBER_LENGTH = 3;
    private static final String VALID_NUMBER_PATTERN = "[1-9]{3}";

    public static void validatePlayerNumber(String playerNumber) {
        if (playerNumber.length() != VALID_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.WRONG_LENGTH.getMessage());
        }
        if (playerNumber.chars().distinct().count() != VALID_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
        }
        if (!playerNumber.matches(VALID_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ErrorCode.OUT_OF_RANGE.getMessage());
        }
    }
}
