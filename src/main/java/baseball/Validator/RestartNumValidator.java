package baseball.Validator;

public class RestartNumValidator {
    private final static String INVALID_INPUT_MESSAGE = "숫자 1이나 2를 입력해주세요";

    public static void validateRestartNum(String input) {
        if (!"1".equals(input) && !"2".equals(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }
}
