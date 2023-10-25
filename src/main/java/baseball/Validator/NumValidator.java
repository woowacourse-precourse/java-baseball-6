package baseball.Validator;

import java.util.Arrays;

public class NumValidator {
    private final static int INPUT_LENGTH = 3;
    private final static int MIN_RANGE_NUMBER = 1;
    private final static int MAX_RANGE_NUMBER = 9;

    private final static String INVALID_INPUT_MESSAGE = "입력 길이는 3입니다.";
    private final static String INVALID_NUMBER_MESSAGE = "숫자로만 이루어진 값을 입력해주세요";
    private final static String OUT_RANGE_NUMBER_MESSAGE = "숫자는 1과 9 사이의 숫자입니다.";
    private final static String DUPLICATE_NUMBER_MESSAGE = "중복된 숫자가 포함되어 있습니다.";

    public static void validateLength(String input) {
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    public static void ValidateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    public static void ValidateDuplication(String input) {
        String[] numbers = input.split("");
        if (numbers.length != Arrays.stream(numbers).distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    public static void validateIsInRange(String input) {
        String[] numbers = input.split("");
        for (String number : numbers) {
            if (Integer.parseInt(number) < MIN_RANGE_NUMBER || Integer.parseInt(number) > MAX_RANGE_NUMBER) {
                throw new IllegalArgumentException(OUT_RANGE_NUMBER_MESSAGE);
            }
        }
    }
}



