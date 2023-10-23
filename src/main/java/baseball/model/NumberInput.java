package baseball.model;

import static baseball.util.InputUtils.INPUT_NUMBERS_IN_SIZE_PATTERN;

public class NumberInput {

    private String input;

    public NumberInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값이 입력되었습니다. 3자리 숫자를 입력해주세요");
        }

        if (!INPUT_NUMBERS_IN_SIZE_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        this.input = input;
    }

    public static NumberInput of(String inputString) {
        return new NumberInput(inputString);
    }

    public String value() {
        return input;
    }
}
