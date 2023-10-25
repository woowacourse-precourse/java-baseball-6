package baseball.exception;

public class CommandException {
    private final static String INVALID_NUMBER_ERROR_MSG = "1또는 2를 입력해주세요.";

    public static void validateRestartNumber(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR_MSG);
        }
    }
}
