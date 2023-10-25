package baseball.validation;

public class InputValidation {
    public static void numbers(String input) {
        if (!input.matches("^[1-9][1-9]{2}$")) {
            throw new IllegalArgumentException("세 자리 숫자이고, 각 자리수가 1에서 9까지인 숫자를 입력해주세요.\"");
        }
        if (input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(2) == input.charAt(0)) {
            throw new IllegalArgumentException("각 자리수가 중복되지 않는 숫자를 입력해주세요.");
        }
    }

    public static void endCommand(String input) {
        if (!input.matches("^[1-2]$")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
