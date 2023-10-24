package baseball.util;

import baseball.domain.BaseballNumber;

public class BaseballNumberConverter {

    private static final int INPUT_LENGTH = 3;
    private static final String INVALID_INPUT_LENGTH_MESSAGE = "입력값은 세자리 숫자여야 합니다.";
    private static final String INVALID_INPUT_FORMAT_MESSAGE = "입력값은 숫자만 포함되어야 합니다.";

    public static BaseballNumber convert(String input) {
        if (input == null || input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException(INVALID_INPUT_LENGTH_MESSAGE);
        }

        try {
            int first = Integer.parseInt(Character.toString(input.charAt(0)));
            int second = Integer.parseInt(Character.toString(input.charAt(1)));
            int third = Integer.parseInt(Character.toString(input.charAt(2)));

            return new BaseballNumber(first, second, third);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT_MESSAGE);
        }
    }
}


