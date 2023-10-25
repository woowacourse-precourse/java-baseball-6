package baseball.controller;

import baseball.ExceptionMessage;
import baseball.SYSTEM_VALUE.GameStatusValue;

public class GameStatusVerifier implements InputVerifier {
    @Override
    public void verify(String input) {
        isNumeric(input);
        isControlNumber(input);
    }

    private void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC);
        }
    }

    private void isControlNumber(String input) {
        int integerInput = Integer.parseInt(input);
        if (integerInput != GameStatusValue.GAME_RESTART && integerInput != GameStatusValue.GAME_EXIT) {
            throw new IllegalArgumentException(ExceptionMessage.UNKNOWN_CONTROL_INPUT);
        }
    }
}
