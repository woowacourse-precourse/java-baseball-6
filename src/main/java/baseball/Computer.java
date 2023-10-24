package baseball;

import java.util.List;

public class Computer implements Rule {
    List<BaseballNumber> numbers;

    public void selectNumbers() {
        numbers = BaseballNumbers.selectByRandom();
    }

    int testNothing(BaseballNumber number) {
        return (numbers.contains(number) ? 0 : 1);
    }

    int testStrike(int index, BaseballNumber number) {
        BaseballNumber numberOfIndex = numbers.get(index);
        return (numberOfIndex.equals(number) ? 1 : 0);
    }
}
