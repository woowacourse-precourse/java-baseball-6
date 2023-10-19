package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {

    private final int MIN_RANDOM_NUMBER = 1;
    private final int MAX_RANDOM_NUMBER = 9;
    private final int RANDOM_NUMBER_LENGTH = 3;

    private final List<Integer> randomNumbers;

    public Computer() {
        this.randomNumbers = generateNewRandomNumbers();
    }

    private List<Integer> generateNewRandomNumbers() {
        List<Integer> newRandomNumbers = new ArrayList<>();
        do {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            newRandomNumbers.add(randomNumber);
            newRandomNumbers = validateDuplicateNumbers(newRandomNumbers);
        } while (newRandomNumbers.size() < RANDOM_NUMBER_LENGTH);
        return newRandomNumbers;
    }

    private List<Integer> validateDuplicateNumbers(List<Integer> randomNumbers) {
        return randomNumbers
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
