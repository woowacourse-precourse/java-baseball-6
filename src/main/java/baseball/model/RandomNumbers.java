package baseball.model;

import baseball.util.NumberConstant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumbers {

    private final List<Number> randomNumbers;

    public RandomNumbers() {
        this.randomNumbers = generateNewRandomNumbers();
    }

    public RandomNumbers(List<Number> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    private List<Number> generateNewRandomNumbers() {
        return Stream.generate(() -> Randoms.pickNumberInRange(NumberConstant.MIN_VALUE, NumberConstant.MAX_VALUE))
                .distinct()
                .limit(NumberConstant.LENGTH)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public List<Number> getRandomNumbers() {
        return randomNumbers;
    }
}
