package baseball;

import java.util.List;

public class User implements Player {
    List<BaseballNumber> numbers;

    public void selectNumbers() {
        numbers = BaseballNumbers.byInput(DIGIT_SIZE);
        // TODO : null인 경우 생각해보기
    }

    BaseballNumber numberOf(int index) {
        return numbers.get(index);
    }
}
