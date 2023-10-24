package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int NUMBER_COUNT = 3;

    private final List<Integer> numbers;

    public Computer() {
        this.numbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
