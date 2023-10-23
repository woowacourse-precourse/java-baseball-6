package baseball.util;

public class ValidationUtils {
    public static void validateInput(String inputValue) {
        if (!inputValue.matches("^[0-9]{3}$")) {
            throw new IllegalArgumentException("숫자 세 자리만 입력해주세요.");
        }

        if (inputValue.charAt(0) == inputValue.charAt(1) || (inputValue.charAt(1) == inputValue.charAt(2))) {
            throw new IllegalArgumentException("서로 다른 3개의 숫자를 입력해주세요.");
        }
    }
}
