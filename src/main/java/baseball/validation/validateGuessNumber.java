package baseball.validation;

import baseball.exception.InvalidLengthException;
import baseball.exception.InvalidNumberForamtException;

import static baseball.domain.Game.NUM_DIGITS;

public class validateGuessNumber {
    public static void validateGuessNumberLength(String guessNumber) {
        if (guessNumber.length() != NUM_DIGITS) {
            throw new InvalidLengthException();
        }
    }

    public static void validateGuessNumberNumeric(String guessNumber) {
        try {
            Integer.parseInt(guessNumber); // 또는 Integer.parseInt(str)
        } catch (NumberFormatException e) {
            throw new InvalidNumberForamtException();
        }
    }
}
