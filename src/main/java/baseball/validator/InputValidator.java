package baseball.validator;

public class InputValidator {
    public static void validateCheckRestartGameInput(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }

}
