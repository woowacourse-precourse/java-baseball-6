package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumbers {

    private final int MIN_NUMERIC_VALUE = 1;
    private final int MAX_NUMERIC_VALUE = 9;
    private final int RANDOM_NUMBER_LENGTH = 3;

    private final List<Number> randomNumbers;

    public RandomNumbers() {
        this.randomNumbers = generateNewRandomNumbers();
    }

    private List<Number> generateNewRandomNumbers() {
        return Stream.generate(() -> Randoms.pickNumberInRange(MIN_NUMERIC_VALUE, MAX_NUMERIC_VALUE))
                .distinct()
                .limit(RANDOM_NUMBER_LENGTH)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public List<Number> getRandomNumbers() {
        return randomNumbers;
    }
}
