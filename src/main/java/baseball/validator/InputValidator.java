package baseball.validator;

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

    private static void checkRange(int intUserInput) {
        if (intUserInput < 100 || intUserInput >= 999) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkIsSameDigit(int intUserInput) {
        int hundreds = intUserInput / 100;
        int tens = (intUserInput / 10) % 10;
        int ones = intUserInput % 10;

        Set<Integer> userInputDigits = new HashSet<>(Arrays.asList(hundreds, tens, ones));
        if (userInputDigits.contains(0) || userInputDigits.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
