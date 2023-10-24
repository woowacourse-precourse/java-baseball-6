package baseball.domain.strategy;

import baseball.domain.Ball;
import baseball.domain.Balls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomBallNumbersGenerateStrategy implements BallNumbersGenerateStrategy {

    @Override
    public String generate() {
        Set<Integer> randomNumbers = new HashSet<>(Balls.VALID_BALL_COUNT);

        while (randomNumbers.size() < Balls.VALID_BALL_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(Ball.MINIMUM_VALID_NUMBER, Ball.MAXIMUM_VALID_NUMBER);
            randomNumbers.add(randomNumber);
        }

        return randomNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}
