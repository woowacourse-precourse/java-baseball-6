package baseball.domain;

import baseball.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class RandomGenerator {

    final private BiFunction<Integer, Integer, Integer> randomFunction;

    public RandomGenerator(BiFunction<Integer, Integer, Integer> randomFunction) {
        this.randomFunction = randomFunction;
    }

    public String generate() {
        List<Integer> randomNumbers = getIntRandomNumbers();
        StringBuilder str = new StringBuilder();
        for (int number : randomNumbers) {
            str.append(number);
        }
        return str.toString();
    }

    private List<Integer> getIntRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < Constants.NUMBER_SIZE) {
            int randomNumber = randomFunction.apply(Constants.RANDOM_LOWER_BOUND, Constants.RANDOM_UPPER_BOUND);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
