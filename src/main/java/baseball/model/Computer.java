package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private static final int RANDOM_MIN_VALUE = 1;
    private static final int RANDOM_MAX_VALUE = 9;
    private static final int RANDOM_NUMBERS_SIZE = 3;

    private final List<Integer> computerNumber;

    public Computer() {
        this.computerNumber = createRandomNumbers();
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    public List<Integer> createRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < RANDOM_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
            numbers.add(randomNumber);
        }
        return new ArrayList<>(numbers);
    }

}
