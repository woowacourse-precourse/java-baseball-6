package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int MAX_NUMBER_LENGTH = BaseballValues.MAX_NUMBER_LENGTH.getValue();
    private static final int MIN_NUMBER = BaseballValues.MIN_NUMBER.getValue();
    private static final int MAX_NUMBER = BaseballValues.MAX_NUMBER.getValue();

    private final List<Integer> numbers;

    Computer() {
        this.numbers = new ArrayList<>();
    }

    Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    void initNumbers() {

        numbers.clear();

        while (this.numbers.size() < MAX_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            addNumberInNumbersNotDuplication(randomNumber);
        }
    }

    private void addNumberInNumbersNotDuplication(int randomNumber) {
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }
}
