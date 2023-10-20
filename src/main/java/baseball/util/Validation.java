package baseball.util;

public class Validation {

    public static void isEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("값을 입력해 주세요.");
        }
    }

    public static void isLengthThree(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해 주세요.");
        }
    }
}
