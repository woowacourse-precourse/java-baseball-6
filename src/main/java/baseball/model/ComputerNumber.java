package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private final List<Integer> numbers;

    private ComputerNumber() {
        this.numbers = generateNumbers();
    }

    public static ComputerNumber create() {
        return new ComputerNumber();
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
