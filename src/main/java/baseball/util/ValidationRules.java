package baseball.util;

import java.util.regex.Pattern;

public class ValidationRules implements ValidationRule {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[1-9]+$");

    @Override
    public void FormatValidationRule(String playerNumber) {
        if (!NUMBER_REGEX.matcher(playerNumber).matches()) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");
        }
    }

    @Override
    public void NumericValidationRule(String playerNumber) {
        try {
            Integer.parseInt(playerNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("T입력 범위를 초과했습니다.");
        }
    }

    @Override
    public void LengthValidationRule(String playerNumber) {
        if (playerNumber.length() != 3) {
            throw new IllegalArgumentException("세 자리 자연수를 입력해 주세요.");
        }
    }
}
