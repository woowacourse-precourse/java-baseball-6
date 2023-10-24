package baseball;

import constants.Constants;

public class ErrorDetector {

    public static void throwIfNumberIsWrong(String number) {
        throwIfInputIsString(number);
        if (number.length() != Constants.BALL_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void throwIfOptionIsWrong(String option) {
        throwIfInputIsString(option);
        if (!option.equals(Constants.REPLAY) && !option.equals(Constants.FINISH)) {
            throw new IllegalArgumentException();
        }
    }

    public static void throwIfInputIsString(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
