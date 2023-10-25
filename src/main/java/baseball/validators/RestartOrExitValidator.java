package baseball.validators;

public class RestartOrExitValidator {
    public static void validateRestartOrExit(String inputString) {
        if (inputString.length() != 1 || (!inputString.equals("1") && !inputString.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }

}
