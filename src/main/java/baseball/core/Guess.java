package baseball.core;

import static baseball.constants.Game.ANSWER_DIGIT;
import static baseball.constants.Game.END_INCLUSIVE;
import static baseball.constants.Game.START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class Guess {
    private final String guess;

    public Guess() {
        String input = Console.readLine();
        validateNumberInput(input);

        guess = input;
    }

    public String getGuess() {
        return guess;
    }

    private void validateNumberInput(String input) {
        validateLengthOfDigits(input);
        validateFormatOfDigits(input);
        validateNoDuplicateDigits(input);
    }

    private void validateLengthOfDigits(String input) {
        if (input.length() != ANSWER_DIGIT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateFormatOfDigits(String input) {
        for (char digit : input.toCharArray()) {
            if (!Character.isDigit(digit) || digit < '0' + START_INCLUSIVE || digit > '0' + END_INCLUSIVE) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNoDuplicateDigits(String input) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char digit : input.toCharArray()) {
            if (!uniqueDigits.add(digit)) {
                throw new IllegalArgumentException();
            }
        }

    }
}
