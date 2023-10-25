package baseball.view;

public class Validator {

    private static final String CONTAINS_CHAR_ERROR_MSG = "숫자를 입력해주세요.";
    private static final String NUMBER_DIGIT_ERROR_MSG = "3자리의 수를 입력해주세요.";
    private static final String REPEATED_NUMBER_ERROR_MSG = "서로 다른 3자리의 수를 입력해주세요.";
    private static final String CONTAINS_ZERO_ERROR_MSG = "0이 포함되지 않는 수를 입력해주세요.";
    private static final String INVALD_RESTART_ERROR_MSG = "1, 2 중 하나를 입력해주세요.";

    public static void invalidUserInputExceptions(String userString) {
        try {
            Integer.parseInt(userString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CONTAINS_CHAR_ERROR_MSG);
        }

        if (userString.length() != 3) {
            throw new IllegalArgumentException(NUMBER_DIGIT_ERROR_MSG);
        }

        if (userString.charAt(0) == userString.charAt(1)
                || userString.charAt(1) == userString.charAt(2)
                || userString.charAt(0) == userString.charAt(2)) {
            throw new IllegalArgumentException(REPEATED_NUMBER_ERROR_MSG);
        }

        if (userString.charAt(0) == '0'
                || userString.charAt(1) == '0'
                || userString.charAt(2) == '0') {
            throw new IllegalArgumentException(CONTAINS_ZERO_ERROR_MSG);
        }
    }

    public static void invalidRestartInputExceptions(String userString) {
        if (!(userString.equals("1") || userString.equals("2"))) {
            throw new IllegalArgumentException(INVALD_RESTART_ERROR_MSG);
        }
    }
}
