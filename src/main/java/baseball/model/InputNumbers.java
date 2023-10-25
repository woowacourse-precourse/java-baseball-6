package baseball.model;

import static baseball.util.InputUtils.INPUT_NUMBERS_IN_SIZE_PATTERN;

public class InputNumbers {

    private String input;

    public InputNumbers(String input) {
        if (!INPUT_NUMBERS_IN_SIZE_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        this.input = input;
    }

    public static InputNumbers of(String input) {
        return new InputNumbers(input);
    }

    public String value() {
        return input;
    }
}
