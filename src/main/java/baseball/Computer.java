package baseball;

import java.util.List;

public class Computer implements Player {
    List<BaseballNumber> numbers;

    @Override
    public void selectNumbers() {
        numbers = BaseballNumbers.selectByRandom(DIGIT_SIZE);
    }

    int testNothing(BaseballNumber number) {
        return (numbers.contains(number) ? 0 : 1);
    }

    int testStrike(int index, BaseballNumber number) {
        BaseballNumber numberOfIndex = numbers.get(index);
        return (numberOfIndex.equals(number) ? 1 : 0);
    }
}
