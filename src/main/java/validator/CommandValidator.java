package validator;

public class CommandValidator {
    private final static String INVALID_TYPE_ERROR_MESSAGE = "1또는 2를 입력해주세요.";

    public static void validateRestartNumber(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException(INVALID_TYPE_ERROR_MESSAGE);
        }
    }
}