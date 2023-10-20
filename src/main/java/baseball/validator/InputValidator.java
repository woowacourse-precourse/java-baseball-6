package baseball.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static Integer validateGuess(String input) {
        Integer intInput;
        intInput = Integer.parseInt(input);
        checkRange(intInput);
        checkIsSameDigit(intInput);
        return intInput;
    }

    private static void checkRange(Integer intInput) {
        if (intInput < 100 || intInput >= 999) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkIsSameDigit(Integer intInput) {
        Integer hundreds = intInput / 100;
        Integer tens = (intInput / 10) % 10;
        Integer ones = intInput % 10;

        Set<Integer> inputDigits = new HashSet<>(Arrays.asList(hundreds, tens, ones));
        if (inputDigits.contains(0) || inputDigits.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
