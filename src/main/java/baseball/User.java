package baseball;

import java.util.List;

public class User implements Rule {
    List<BaseballNumber> numbers;

    public void selectNumbers() {
        numbers = BaseballNumbers.selectByInput();
    }

    BaseballNumber numberOf(int index) {
        return numbers.get(index);
    }
}
