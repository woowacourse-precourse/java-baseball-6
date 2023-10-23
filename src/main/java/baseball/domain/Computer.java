package baseball.domain;

import baseball.view.GameValue;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final Numbers numbers;

    public Computer() {
        this.numbers = createComputerNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers.getNumbers();
    }

    private Numbers createComputerNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < GameValue.NUMBER_SIZE.getValue()) {
            addUniqueRandomNumber(numbers);
        }
        return new Numbers(numbers);
    }

    private void addUniqueRandomNumber(List<Integer> numbers) {
        int number = Randoms.pickNumberInRange(GameValue.MIN_RANGE.getValue(), GameValue.MAX_RANGE.getValue());
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
