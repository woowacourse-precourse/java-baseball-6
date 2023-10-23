package baseball.utils;

public class Validator {

    public static void validateStringEmptyOrNull(String string) {
        if (string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 null이거나 비어있습니다.");
        }
    }

    public static void validateStringDigit(String string) {
        boolean isAllDigits = string.chars()
                .allMatch(Character::isDigit);
        if (!isAllDigits) {
            throw new IllegalArgumentException("[ERROR] 입력 값에 숫자가 아닌 문자가 포함되어 있습니다.");
        }
    }
}
