package baseball.domain;

import baseball.util.Validator;
import java.util.List;

public class BaseballNumbers {
    private List<Integer> baseballNumbers;

    public BaseballNumbers(List<Integer> baseballNumbers) {
        validate(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    public static void validate(List<Integer> baseballNumbers) {
        if (Validator.isInvalid(baseballNumbers)) {
            throw new IllegalArgumentException(Errors.getInvalidInputMessage());
        }
    }

    public int get(int index) {
        return baseballNumbers.get(index);
    }

    public boolean contains(int number) {
        return baseballNumbers.contains(number);
    }

    public void clear() {
        baseballNumbers.clear();
    }
}
