package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Constants.*;

public class Computer {
    private final List<Integer> numbers;

    public Computer() {
        this.numbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_MIN_RANGE, NUMBER_MAX_RANGE);
            uniqueNumbers.add(randomNumber);
        }
        return new ArrayList<>(uniqueNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
