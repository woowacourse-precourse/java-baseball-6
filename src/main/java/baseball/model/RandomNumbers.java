package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumbers {

    private final int MIN_RANDOM_NUMBER = 1;
    private final int MAX_RANDOM_NUMBER = 9;
    private final int RANDOM_NUMBER_LENGTH = 3;

    private final List<Number> randomNumbers;


    public RandomNumbers() {
        this.randomNumbers = generateNewRandomNumbers();
    }

    private List<Number> generateNewRandomNumbers() {
        List<Number> newRandomNumbers = new ArrayList<>();
        do {
            int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            Number randomNumber = new Number(randomValue);
            newRandomNumbers.add(randomNumber);
            newRandomNumbers = validateDuplicateNumbers(newRandomNumbers);
        } while (newRandomNumbers.size() < RANDOM_NUMBER_LENGTH);
        return newRandomNumbers;
    }

    private List<Number> validateDuplicateNumbers(List<Number> randomNumbers) {
        return randomNumbers
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
