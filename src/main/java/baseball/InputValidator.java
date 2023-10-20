package baseball;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String REGEX = "^[0-9]+$";
    private static final String ELEMENT = "";
    private static final int COUNT_OF_NUMBER = 3;

    public void validateNumber(String number) {
        validateCountOfNumber(number);
        validateNumberIsDigit(number);
        validateNumberHasDuplicate(number);
    }

    private void validateNumberIsDigit(String number) {
        if (!Pattern.matches(REGEX, number)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_DIGIT.toString());
        }
    }

    private void validateNumberHasDuplicate(String number) {
        if(number.length() != Arrays.stream(number.split(ELEMENT)).distinct().count()){
            throw new IllegalArgumentException(ExceptionMessage.HAS_DUPLICATE.toString());
        }
    }

    private void validateCountOfNumber(String number) {
        if (number.length() != COUNT_OF_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_THREE.toString());
        }
    }
}
