package baseball.controller;

import baseball.SYSTEM_VALUE.GameStatusValue;

public class GameStatusVerifier implements InputVerifier {
    @Override
    public void verify(String input) throws IllegalArgumentException {
        isNumeric(input);
        isControlNumber(input);
    }

    private void isNumeric(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void isControlNumber(String input) {
        int integerInput = Integer.parseInt(input);
        if (integerInput != GameStatusValue.GAME_RESTART && integerInput != GameStatusValue.GAME_EXIT) {
            throw new IllegalArgumentException("1 또는 2가 아닙니다.");
        }
    }
}
