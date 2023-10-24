package baseball.model;

import baseball.util.BaseballNumberConstant;
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
        return Stream.generate(
                        () -> Randoms.pickNumberInRange(BaseballNumberConstant.MIN_VALUE, BaseballNumberConstant.MAX_VALUE))
                .distinct()
                .limit(BaseballNumberConstant.LENGTH)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public List<Number> getRandomNumbers() {
        return randomNumbers;
    }
}
