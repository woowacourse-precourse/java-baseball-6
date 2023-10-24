package baseball.game;

import java.util.regex.Pattern;

public class Validation {
    static final String DIGIT_PATTERN = "^[1-9]*$";

    public static boolean allPossibleDigit(String qeury) {
        return Pattern.matches(DIGIT_PATTERN, qeury);
    }
}
