package baseball.validator;

import baseball.util.NumberConstant;

public class BaseballNumberInputValidation {

    public void validate(String input) {
        isNumeric(input);
        isTripleDigit(input);
        isValidDigitRange(input);
        hasNoDuplicates(input);
    }

    private void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private void isTripleDigit(String input) {
        if (input.length() != NumberConstant.LENGTH) {
            throw new IllegalArgumentException("세 자리의 입력값이 아닙니다.");
        }
    }

    private void isValidDigitRange(String input) {
        if (input.contains(NumberConstant.ZERO)) {
            throw new IllegalArgumentException("1에서 9사이가 아닌 값이 포함되어 있습니다.");
        }
    }

    private void hasNoDuplicates(String input) {
        long distinctCharsCount = input.chars()
                .distinct()
                .count();

        if (distinctCharsCount < NumberConstant.LENGTH) {
            throw new IllegalArgumentException("중복된 값이 존재합니다.");
        }
    }
}
