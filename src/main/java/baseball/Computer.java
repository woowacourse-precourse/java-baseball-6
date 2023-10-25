package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int NUMBER_COUNT = 3;
    private List<Integer> numbers;

    public Computer() {
        this.numbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        List<Integer> generatedNumbers = new ArrayList<>();

        while (generatedNumbers.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
            }
        }

        return generatedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
