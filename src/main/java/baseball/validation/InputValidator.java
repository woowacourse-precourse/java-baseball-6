package baseball.validation;

import baseball.model.Rule;

public class InputValidator {

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
}
