package baseball.domain.strategy;

import baseball.domain.Ball;
import baseball.domain.Balls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomBallNumbersGenerateStrategy implements BallNumbersGenerateStrategy {

    @Override
    public String generate() {
        List<Integer> randomNumbers = new ArrayList<>(Balls.VALID_BALL_COUNT);

        while (randomNumbers.size() < Balls.VALID_BALL_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(Ball.MINIMUM_VALID_NUMBER, Ball.MAXIMUM_VALID_NUMBER);
            addIfNotContains(randomNumbers, randomNumber);
        }

        return randomNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private void addIfNotContains(List<Integer> randomNumbers, int randomNumber) {
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }

}
