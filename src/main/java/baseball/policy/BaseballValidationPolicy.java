package baseball.policy;

public class BaseballValidationPolicy implements ValidationPolicy {

    public void isCorrectLength(String input, int length) {
        if (!(input.length() == length)) {
            throw new IllegalArgumentException("입력 숫자는 " + length + "자리여야 합니다.");
        }
    }

    public void isNumericString(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
            }
        }
    }

    public void hasNoDuplicateNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            for (int j = i + 1; j < input.length(); j++) {
                if (digit == input.charAt(j)) {
                    throw new IllegalArgumentException("각 자리의 수가 중복되지 않는 3자리 수를 입력해주세요.");
                }
            }
        }
    }

    public void hasNoZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 사용해 입력해주세요.");
        }
    }

    public void isNullOrEmpty(String input) {
        if (input == null || input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 null이거나 비어있습니다.");
        }
    }
}
