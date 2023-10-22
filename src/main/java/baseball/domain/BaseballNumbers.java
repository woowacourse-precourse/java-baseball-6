package baseball.domain;

import baseball.util.Validator;
import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private List<Integer> baseballNumbers = new ArrayList<>();

    public BaseballNumbers(List<Integer> baseballNumbers) {
        validate(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private void validate(List<Integer> baseballNumbers) {
        if (Validator.isInvalid(baseballNumbers)) throw new IllegalArgumentException(InputView.MSG_EXCEPTION_INVALID_INPUT);
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
