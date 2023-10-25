package baseball.validator;

import static baseball.common.Constants.DIGIT_COUNT;
import static baseball.common.Constants.MAXIMUM_INPUT_NUMBER;
import static baseball.common.Constants.MINIMUM_INPUT_NUMBER;
import static baseball.common.Constants.WANT_TO_RESTART;
import static baseball.common.Constants.WANT_TO_STOP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static int validateGuess(String userInput) {
        int intUserInput = Integer.parseInt(userInput);
        checkRange(intUserInput);
        checkIsSameDigit(intUserInput);
        return intUserInput;
    }

    public static int validateRestart(String userInput) {
        int intUserInput = Integer.parseInt(userInput);
        if (intUserInput != WANT_TO_RESTART && intUserInput != WANT_TO_STOP) {
            throw new IllegalArgumentException();
        }
        return intUserInput;
    }

    private static void checkRange(int intUserInput) {
        if (intUserInput < MINIMUM_INPUT_NUMBER || intUserInput >= MAXIMUM_INPUT_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkIsSameDigit(int intUserInput) {
        int hundreds = intUserInput / 100;
        int tens = (intUserInput / 10) % 10;
        int ones = intUserInput % 10;

        Set<Integer> userInputDigits = new HashSet<>(Arrays.asList(hundreds, tens, ones));
        if (userInputDigits.contains(0) || userInputDigits.size() != DIGIT_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
