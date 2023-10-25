package baseball.validator;

import java.util.Arrays;

public class NumberCheck {

    private final static String NOT_NUMBER_ERROR_MESSAGE = "숫자만 입력해주세요.";
    private final static String LENGTH_OUT_ERROR_MESSAGE = "3자리의 숫자를 입력해주세요.";
    private final static String DUPLICATE_ERROR_MESSAGE = "중복된 숫자는 입력하면 안 됩니다.";
    private final static String RANGE_OUT_ERROR_MESSAGE = "1~9 사이의 숫자를 입력해주세요.";
    private final static String RESTART_ERROR_MESSAGE = "1 혹은 2를 입력해주세요.";

    public static void notNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void digitNumber(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(LENGTH_OUT_ERROR_MESSAGE);
        }
    }

    public static void duplicateNumber(String input) {
        String[] TestNumbers = input.split("");
        if (TestNumbers.length != Arrays.stream(TestNumbers).distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void rangeOut(String input) {
        String[] Testnumbers = input.split("");
        for (String Testnumber : Testnumbers) {
            if (Integer.parseInt(Testnumber) == 0) {
                throw new IllegalArgumentException(RANGE_OUT_ERROR_MESSAGE);
            }
        }
    }

    public static void reStartOrOverCheck(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException(RESTART_ERROR_MESSAGE);
        }
    }
}