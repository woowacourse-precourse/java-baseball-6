package baseball.game;

import baseball.utils.Validator;
import java.util.Collections;
import java.util.List;

public class GameNumbers {
    private List<Integer> numbers;

    public GameNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int getNumberByIndex(int index) {
        return numbers.get(index);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int size() {
        return numbers.size();
    }

    private static void validate(List<Integer> numbers) {
        Validator.validateNumbersSize(numbers);
        Validator.validateNumberRange(numbers);
        Validator.validateIsContainDuplicateNumber(numbers);
    }
}
