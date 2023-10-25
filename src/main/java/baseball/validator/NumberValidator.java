package baseball.validator;

import java.util.Arrays;

import static baseball.constant.Const.*;

public class NumberValidator {

    public static String validateConditions(String inputNumber) {
        validateNumeric(inputNumber);
        validateDuplicated(inputNumber);
        validateNumberOfDigit(inputNumber);
        validateRange(inputNumber);
        return inputNumber;
    }

    public static void validateNumeric(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static void validateRange(String inputNumber) {
        String[] numbers = inputNumber.split("");
        for (String number : numbers) {
            if(Integer.parseInt(number)<MIN_NUMBER_RANGE || Integer.parseInt(number) > MAX_NUMBER_RANGE){
                throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public static void validateNumberOfDigit(String inputNumber) {
        if (inputNumber.length() != MAX_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_DIGIT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateDuplicated(String inputNumber) {
        String[] numbers = inputNumber.split("");
        if (Arrays.stream(numbers).distinct().count() != MAX_NUMBER_SIZE) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }

}
