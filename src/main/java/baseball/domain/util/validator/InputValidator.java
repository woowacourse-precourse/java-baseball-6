package baseball.domain.util.validator;

import baseball.domain.config.GameConfig;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final int BASEBALL_SIZE = GameConfig.BASEBALL_SIZE;
    private static final int BASEBALL_MIN_NUMBER = GameConfig.BASEBALL_MIN_NUMBER;
    private static final int BASEBALL_MAX_NUMBER = GameConfig.BASEBALL_MAX_NUMBER;
    private static final String NOT_HOW_MANY_NUMBER_ERROR_MESSAGE = "개의 숫자를 입력해야 합니다.";
    private static final String NOT_RANGE_NUMBERS_ERROR_MESSAGE = "입력된 값은 %d~%d 사이의 숫자만 가능합니다.";
    private static final String NUMBER_DUPLICATION_ERROR_MESSAGE = "입력된 숫자에 중복된 값이 있습니다.";
    private static final String NOT_NUMBER = "숫자를 입력해야 합니다.";

    public static void checkBaseballNumberSize(String input) {
        if (input == null || input.length() != BASEBALL_SIZE) {
            throw new IllegalArgumentException(BASEBALL_SIZE + NOT_HOW_MANY_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void checkBetweenMinAndMax(String input) {
        for (char c : input.toCharArray()) {
            int number = c - '0';
            if (number < BASEBALL_MIN_NUMBER || number > BASEBALL_MAX_NUMBER) {
                throw new IllegalArgumentException(
                        String.format(NOT_RANGE_NUMBERS_ERROR_MESSAGE, BASEBALL_MIN_NUMBER, BASEBALL_MAX_NUMBER));
            }
        }
    }

    public static void checkDuplicationNumber(String input) {
        Set<Character> uniqueNumbers = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (uniqueNumbers.contains(c)) {
                throw new IllegalArgumentException(NUMBER_DUPLICATION_ERROR_MESSAGE);
            }
            uniqueNumbers.add(c);
        }
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }
}
