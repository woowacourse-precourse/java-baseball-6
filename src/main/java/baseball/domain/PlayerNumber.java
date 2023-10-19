package baseball.domain;

import baseball.validation.NumberDuplicateValidator;
import baseball.validation.NumberFormatValidator;
import baseball.validation.NumberRangeValidator;
import baseball.validation.NumberSizeValidator;

public class PlayerNumber {
    private final String number;

    public PlayerNumber(String number) {
        NumberRangeValidator.validate(number);
        NumberDuplicateValidator.validate(number);
        NumberSizeValidator.validate(number);
        NumberFormatValidator.validate(number);
        this.number = number;
    }

    @Override
    public String toString() {
        return number;
    }
}
