package baseball.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUniqueBallNumbersGenerateStrategy implements BallNumbersGenerateStrategy {

    private RandomUniqueBallNumbersGenerateStrategy() {
    }

    public static BallNumbersGenerateStrategy instance() {
        return new RandomUniqueBallNumbersGenerateStrategy();
    }

    @Override
    public List<Integer> generate(int startInclusive, int endInclusive, int count) {
        List<Integer> randomNumbers = new ArrayList<>(count);

        while (randomNumbers.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            addIfNotContains(randomNumbers, randomNumber);
        }

        return Collections.unmodifiableList(randomNumbers);
    }

    private void addIfNotContains(List<Integer> randomNumbers, int randomNumber) {
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }

}
