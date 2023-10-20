package baseball.util;

public class Validation {

    public static void isEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("값을 입력해 주세요.");
        }
    }
}
