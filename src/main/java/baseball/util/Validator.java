package baseball.util;

import java.util.regex.Pattern;

public class Validator {
    private static final String INVALID_INPUT = "유효하지 않은 입력입니다.";
    private static final String INVALID_RESTART_OR_EXIT = "입력 값은 1 (재시작) 또는 2 (종료) 여야 합니다.";
    private static final Pattern THREE_DIGITS_REGEX = Pattern.compile("^^[1-9]{3}$");
    private static final Pattern DUPLICATE_DIGITS_REGEX = Pattern.compile("(\\d).*\\1");
    private static final Pattern RESTART_OR_EXIT_REGEX = Pattern.compile("[1-2]");

    public static void validateInputNumbers(String input) {
        if (!isValidThreeDigits(input) || hasDuplicateDigits(input)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    public static boolean isValidThreeDigits(String input) {
        return THREE_DIGITS_REGEX.matcher(input).matches();
    }

    public static boolean hasDuplicateDigits(String input) {
        return DUPLICATE_DIGITS_REGEX.matcher(input).find();
    }

    public static void validateRestartOrExitNumber(String input) {
        if (!isValidRestartOrExit(input)) {
            throw new IllegalArgumentException(INVALID_RESTART_OR_EXIT);
        }
    }

    public static boolean isValidRestartOrExit(String input) {
        return RESTART_OR_EXIT_REGEX.matcher(input).matches();
    }
}
