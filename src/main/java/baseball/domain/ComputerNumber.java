package baseball.domain;

import baseball.validation.NumberDuplicateValidator;
import baseball.validation.NumberRangeValidator;
import baseball.validation.NumberSizeValidator;

public class ComputerNumber {
    private final String number;

    public ComputerNumber(String number) {
        NumberRangeValidator.validate(number);
        NumberDuplicateValidator.validate(number);
        NumberSizeValidator.validate(number);
        this.number = number;
    }

    @Override
    public String toString() {
        return number;
    }
}
