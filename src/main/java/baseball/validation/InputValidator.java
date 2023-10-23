package baseball.validation;

import baseball.model.Rule;

public class InputValidator {

    public static void validatePatternWithUnique(String stringNumber) {
        validateNumberWithPattern(stringNumber);
        validateUniqueNumber(stringNumber);
    }

    private static void validateNumberWithPattern(String stringNumber) {
        String pattern = "^["
                + Rule.START_NUMBER
                + "-"
                + Rule.END_NUMBER
                + "]{" + Rule.MAX_LENGTH + "}$";

        if (!stringNumber.matches(pattern)) {
            throw new IllegalArgumentException("1~9 사이의 숫자를 3개 입력해주세요.");
        }
    }

    private static void validateUniqueNumber(String stringNumber) {
        int[] digitCounts = new int[10];

        for (char c : stringNumber.toCharArray()) {
            int digit = Character.getNumericValue(c);
            digitCounts[digit]++;
            if (digitCounts[digit] > 1) {
                throw new IllegalArgumentException("각 숫자는 한 번만 나와야 합니다.");
            }
        }
    }

}
