package baseball.exception;

import java.util.HashSet;

// 예외 처리를 위한 Class
public class NumberException {

    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 9;
    private final static int INPUT_DIGIT = 3;
    private final static String NON_NUMERIC_INPUT_MSG = "숫자 만을 입력 해야 합니다.";
    private final static String INVALID_RANGE_MSG = "숫자의 범위는 1 ~ 9 사이 입니다.";
    private final static String DUPLICATE_MSG = "중복된 숫자가 존재 합니다.";
    private final static String INVALID_DIGIT_MSG = "세자리 숫자를 입력 해야 합니다.";

    // 숫자 유효성 Validation
    public static void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT_MSG);
        }
    }

    // 범위 Validation
    public static void validateRange(String input) {
        String[] numbers = input.split("");
        for (String number : numbers) {
            if (Integer.parseInt(number) < MIN_RANGE || Integer.parseInt(number) > MAX_RANGE) {
                throw new IllegalArgumentException(INVALID_RANGE_MSG);
            }
        }
    }

    // 중복 Validation
    public static void validateDuplicate(String input) {
        String[] numbers = input.split("");
        HashSet<String> numberSet = new HashSet<>();

        for (String number : numbers) {
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException(DUPLICATE_MSG);
            }
        }
    }

    // 입력 숫자 수 Validation
    public static void validateDigit(String input) {
        if (input.length() != INPUT_DIGIT) {
            throw new IllegalArgumentException(INVALID_DIGIT_MSG);
        }
    }

}
