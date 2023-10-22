package baseball.domain;

import baseball.validation.NumberDuplicateValidator;
import baseball.validation.NumberFormatValidator;
import baseball.validation.NumberRangeValidator;
import baseball.validation.NumberSizeValidator;
import java.util.Collections;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        NumberFormatValidator.validate(numbers);
        NumberRangeValidator.validate(numbers);
        NumberDuplicateValidator.validate(numbers);
        NumberSizeValidator.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
