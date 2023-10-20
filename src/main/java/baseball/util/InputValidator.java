package baseball.util;

import java.util.regex.Pattern;

/**
 * 주로 View에서 입력받은 값을 검증하는 클래스
 */
public final class InputValidator {

    private static final Pattern NUMBER_FORMAT = Pattern.compile("[0-9]+");
    private static final Pattern ONE_DIGIT_NUMBER_FORMAT = Pattern.compile("[0-9]{1}");
    private static final String BLANK_EXCEPTION_MESSAGE = "공백은 입력할 수 없습니다.";
    private static final String FORMAT_EXCEPTION_MESSAGE = "형식에 맞지 않습니다.";

    private InputValidator() {
    }

    public static void validateBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isBlank(String input) {
        return input.isBlank();
    }

    public static void validateNumberFormat(String input) {
        if (!isRightFormat(NUMBER_FORMAT, input)) {
            throw new IllegalArgumentException(FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isRightFormat(Pattern pattern, String input) {
        return pattern.matcher(input).matches();
    }

    public static void validateOneDigitNumber(String input) {
        if (!isRightFormat(ONE_DIGIT_NUMBER_FORMAT, input)) {
            throw new IllegalArgumentException(FORMAT_EXCEPTION_MESSAGE);
        }
    }

}
