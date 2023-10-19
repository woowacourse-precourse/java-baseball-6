package baseball.utils;

import java.util.regex.Pattern;

public class Validator {

    public static void validateBallNumbers(String input) {
        if (isNotDigit(input)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static boolean isNotDigit(String input) {
        return !Pattern.matches("-?[0-9]+", input);
    }

    public static void validateRestartOptionNumber(String input) {
        if (isIncorrectInput(input)) {
            throw new IllegalArgumentException("게임 재시작/종료 여부에 대한 입력은 1 또는 2로만 가능합니다.");
        }
    }

    private static boolean isIncorrectInput(String input) {
        return !Pattern.matches("[1|2]", input);
    }
}
