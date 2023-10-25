package baseball.utils;

import static baseball.utils.ErrorMessages.NOT_INTEGER;

public class IntegerConvertor {
    public static int toInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }
}
