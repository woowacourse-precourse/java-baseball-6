package baseball.exception;

public class Exception {

    public static void validateInputLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }

    public static void validateNumericInput(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    public static void validateRestartInput(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("올바른 선택지가 아닙니다. 1 또는 2 중 하나를 입력하세요.");
        }
    }
}
