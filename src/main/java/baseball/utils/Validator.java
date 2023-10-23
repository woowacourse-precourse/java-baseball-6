package baseball.utils;

/**
 * 입력받은 String을 검증하기 위해 공통으로 사용되는 클래스
 */

public class Validator {

    /**
     * 입력받은 String이 널 또는 공백으로만 이루어져 있는지 검사
     *
     * @param string 검사할 입력 String
     */

    public static void validateStringEmptyOrNull(String string) {
        if (string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 null이거나 비어있습니다.");
        }
    }

    /**
     * 입력받은 String이 숫자 값으로만 이루어져 있는지 검사
     *
     * @param string 검사할 입력 String
     */

    public static void validateStringDigit(String string) {
        boolean isAllDigits = string.chars()
                .allMatch(Character::isDigit);
        if (!isAllDigits) {
            throw new IllegalArgumentException("[ERROR] 입력 값에 숫자가 아닌 문자가 포함되어 있습니다.");
        }
    }
}
