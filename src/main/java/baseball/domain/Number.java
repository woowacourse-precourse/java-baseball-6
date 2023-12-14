package baseball.domain;

import static baseball.global.validator.Validator.validateRange;

public class Number {
    private static final int START = 1;
    private static final int END = 9;
    private Integer value;

    public Number(Integer value) {
        Validator.validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private static class Validator {
        public static void validate(int value) {
            validateRange(value, 1, 9);
        }
    }
}
