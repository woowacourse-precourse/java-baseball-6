package baseball;

import static baseball.ErrorMessage.*;

public class Validator {


    public static boolean isDigitsUnique(String number) {
        int numericValue = Integer.parseInt(number);
        int hundredsPlace = numericValue / 100;
        int tensPlace = (numericValue / 10) % 10;
        int onesPlace = numericValue % 10;

        return hundredsPlace != tensPlace && tensPlace != onesPlace && onesPlace != hundredsPlace;
    }


    public static boolean isNumber(String userNumber) {
        try {
            Integer.parseInt(userNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInRange(String userNumber, int startRange, int endRange) {
        int number = Integer.parseInt(userNumber);
        if (number >= startRange && number <= endRange) {
            return true;
        }
        return false;
    }

    public static boolean isContainZero(String number) {
        return number.contains("0");
    }

    public static void validateUserNumber(String userNumber) {
        if (!isNumber(userNumber)) {
            throw new IllegalArgumentException(NOT_NUMERIC.getMessage());
        }
        if (!isInRange(userNumber, 100, 999)) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
        if (!isDigitsUnique(userNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
        if (isContainZero(userNumber)) {
            throw new IllegalArgumentException(ZERO_CONTAIN.getMessage());
        }
    }
}
