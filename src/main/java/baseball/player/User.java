package baseball.player;

import baseball.BaseballNumber;
import baseball.BaseballNumbers;
import baseball.Rule;
import java.util.List;

public class User implements Rule {
    List<BaseballNumber> numbers;

    public void selectNumbers() {
        numbers = BaseballNumbers.selectByInput();
    }

    public BaseballNumber numberOf(int index) {
        return numbers.get(index);
    }
}
