package baseball;

public class InputValidator {

    public static void validate(String userInput) {
        validateLength(userInput);
        validateRange(userInput);
        validateNoDuplicate(userInput);
    }

    private static void validateLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("사용자 입력이 3자리 수가 아닙니다.");
        }
    }

    private static void validateRange(String userInput) {
        for (char c : userInput.toCharArray()) {
            if (Character.getNumericValue(c) < 1 || Character.getNumericValue(c) > 9) {
                throw new IllegalArgumentException("사용자 입력 범위는 1-9 사이 값이어야 합니다.");
            }
        }
    }

    private static void validateNoDuplicate(String userInput) {
        for (char c : userInput.toCharArray()) {
            if (userInput.indexOf(c) != userInput.lastIndexOf(c)) {
                throw new IllegalArgumentException("사용자 입력이 중복되었습니다.");
            }
        }
    }
}
