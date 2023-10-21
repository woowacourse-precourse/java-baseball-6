package baseball.validator;

import baseball.util.Util;

public class Validator {
    public static final String NATURAL_NUMBER_REGULAR_EXPRESSION = Util.NATURAL_NUMBER_REGULAR_EXPRESSION;

    public static void validateStringIsNaturalNumber(String string, String exceptionMessage) {
        if (!string.matches(NATURAL_NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }


    public static void validateStringHasNot(String notContainsString, String string, String exceptionMessage) {
        if (string.contains(notContainsString)) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void validateStringLength(int length, String string, String exceptionMessage) {
        if (string.length() != length) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void validateStringAllDifferent(String string, String exceptionMessage) {
        for (int i = 0; i < string.length(); i++) {
            String stringByIdx = String.valueOf(string.charAt(i));
            String stringRemoveByIdx = string.substring(0, i) + string.substring(i + 1);
            if (stringRemoveByIdx.contains(stringByIdx)) {
                throw new IllegalArgumentException(exceptionMessage);
            }
        }
    }

    public static void validateStringIsOneOrTwo(String string) {
        if (!string.equals("1") && !string.equals("2")) {
            throw new IllegalArgumentException("1, 2 중 하나를 입력해주세요");
        }
    }
}
