package baseball.util;

public class BlankValidator {
    private static final String BLANK_EXCEPTION_MESSAGE = "공백 문자는 입력할 수 없습니다.";

    public static void validate(String input) {
        validateBlank(input);
    }

    private static void validateBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isBlank(String input) {
        return input.isBlank();
    }
}
