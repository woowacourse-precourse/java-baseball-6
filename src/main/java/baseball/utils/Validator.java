package baseball.utils;

public class Validator {

    public static void validateStringEmptyOrNull(String string) {
        if (string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 null이거나 비어있습니다.");
        }
    }

    public static void validateStringDigit(String string) {
        for (char ch : string.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("[ERROR] 입력 값이 숫자로만 이루어져 있지 않습니다.");
            }
        }
    }
}
