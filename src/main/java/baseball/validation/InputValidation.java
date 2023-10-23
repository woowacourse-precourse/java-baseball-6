package baseball.validation;

public class InputValidation {

    public static void Number (String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }
        if (!input.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    public static void GameEnd(String input) {
        if (!input.matches("^[1-2]*$")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
