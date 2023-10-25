package baseball.validation;

import java.util.HashSet;
import java.util.Set;

public class GameInputValidator implements InputValidator {

    @Override
    public void validateInput(String input) {
        checkInputLengthValidity(input);
        checkInputRangeValidity(input);
        checkInputUniquenessValidity(input);
        checkInputIsNumeric(input);
    }

    private void checkInputLengthValidity(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInputRangeValidity(String input) throws IllegalArgumentException {
        for (char c : input.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit < 1 || digit > 9) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkInputUniquenessValidity(String input) throws IllegalArgumentException {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!uniqueDigits.add(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkInputIsNumeric(String input) throws IllegalArgumentException {
        for (char c : input.toCharArray()) {
            if(!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

}
