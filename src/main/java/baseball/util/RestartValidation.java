package baseball.util;

public class RestartValidation {

    public static void RestartValidate(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
    }

}