package baseball;

import java.util.List;

public class User implements Player {
    List<BaseballNumber> numbers;

    public void selectNumbers() {
        numbers = BaseballNumbers.byInput(DIGIT_SIZE);
    }

    BaseballNumber numberOf(int index) {
        return numbers.get(index);
    }
}
