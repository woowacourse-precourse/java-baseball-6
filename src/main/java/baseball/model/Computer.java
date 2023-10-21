package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int RANDOM_NUMBER_LENGTH = 3;

    private final List<Integer> numbers;

    public Computer() {
        this.numbers = getRandomNumbers();
    }

    private List<Integer> getRandomNumbers() {
        Set<Integer> computerNumber = new HashSet<>();

        while(computerNumber.size() < RANDOM_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

            computerNumber.add(randomNumber);
        }

        return computerNumber.stream().toList();
    }
}
