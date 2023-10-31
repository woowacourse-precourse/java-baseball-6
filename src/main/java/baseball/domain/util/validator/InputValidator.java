package baseball.domain.util.validator;

import baseball.domain.config.GameConfig;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final int BASEBALL_SIZE = GameConfig.BASEBALL_SIZE;
    private static final int BASEBALL_MIN_NUMBER = GameConfig.BASEBALL_MIN_NUMBER;
    private static final int BASEBALL_MAX_NUMBER = GameConfig.BASEBALL_MAX_NUMBER;

    public static void checkBaseballNumberSize(String input) {
        if (input == null || input.length() != BASEBALL_SIZE) {
            throw new IllegalArgumentException(BASEBALL_SIZE + "개의 숫자를 입력해야 합니다.");
        }
    }

    public static void checkBetweenMinAndMax(String input) {
        for (char c : input.toCharArray()) {
            int number = c - '0';
            if (number < BASEBALL_MIN_NUMBER || number > BASEBALL_MAX_NUMBER) {
                throw new IllegalArgumentException(
                        "입력된 값은 "
                                + BASEBALL_MIN_NUMBER + "~" + BASEBALL_MAX_NUMBER
                                + " 사이의 숫자만 가능합니다.");
            }
        }
    }

    public static void checkDuplicationNumber(String input) {
        Set<Character> uniqueNumbers = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (uniqueNumbers.contains(c)) {
                throw new IllegalArgumentException("입력된 숫자에 중복된 값이 있습니다.");
            }
            uniqueNumbers.add(c);
        }
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
