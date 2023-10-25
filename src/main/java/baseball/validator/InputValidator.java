package baseball.validator;

public class InputValidator {

    private static final String INVALID_INPUT_MESSAGE = "올바른 입력이 아닙니다.";

    //인스턴스화 방지
    private InputValidator() {
        throw new AssertionError();
    }
    
    public static void validate(String message) {
        if (isBlank(message)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private static boolean isBlank(String message) {
        return message == null || message.isBlank();
    }
}
