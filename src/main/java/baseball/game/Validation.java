package baseball.game;

import baseball.Exception.NotEscapeCodeException;
import baseball.Exception.SizeNotMatchException;

import java.util.regex.Pattern;

public class Validation {
    static final String DIGIT_PATTERN = "^[1-9]*$";
    static final String ONE_TOW_PATTERN = "^[1-2]*$";

    public static boolean allPossibleDigit(String qeury) {
        return Pattern.matches(DIGIT_PATTERN, qeury);
    }

    public static void checkRestartString(String inputStatus) {
        checkLength(inputStatus);
        checkValidNumber(inputStatus);
    }

    private static void checkValidNumber(String inputStatus) {
        if (!Pattern.matches(ONE_TOW_PATTERN, inputStatus)) {
            throw new NotEscapeCodeException();
        }
    }

    private static void checkLength(String inputStatus) {
        if (inputStatus.length() != 1) {
            throw new SizeNotMatchException();
        }
    }
}
