package baseball.util.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidatorImpl implements InputValidator {
    private final boolean VALID_SUCCESS = true;
    private final boolean VALID_FAILED = false;

    @Override
    public boolean validate(
            String input,
            int numberDigits,
            int startInclusive,
            int endInclusive,
            boolean validateUniqueValue
    ) {
        if ( input.length() != numberDigits )
            return VALID_FAILED;

        String regex = "^[" + startInclusive + "-" + endInclusive + "]*$";
        if ( !input.matches(regex) )
            return VALID_FAILED;

        if ( validateUniqueValue )
            return validateUniqueValue(input);

        return VALID_SUCCESS;
    }

    @Override
    public boolean validate(String input, int numberDigits, int startInclusive, int endInclusive) {
        return validate(input, numberDigits, startInclusive, endInclusive, false);
    }

    private boolean validateUniqueValue(String inputNumbers) {
        Set<Character> usedNumbers = new HashSet<>();

        for ( char number : inputNumbers.toCharArray() ) {
            if ( !usedNumbers.add(number) )
                return VALID_FAILED;
        }

        return VALID_SUCCESS;
    }
}
