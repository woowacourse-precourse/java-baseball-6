package baseball.player;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.common.Constants.*;

public class Computer {
    private final Numbers numbers;

    public Computer() {
        this.numbers = generateNumbers();
    }

    private Numbers generateNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_MIN_RANGE, NUMBER_MAX_RANGE);
            randomNumbers.add(randomNumber);
        }
        return new Numbers(new ArrayList<>(randomNumbers));
    }

    public List<Integer> getNumbers() {
        return numbers.getNumbers();
    }
}
