package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomBallsGenerator implements BallsGenerator {

    private static final int FIRST_POSITION_NUMBER = 1;
    private static final int END_POSITION_NUMBER = 4;

    public static BallsGenerator init() {
        return new RandomBallsGenerator();
    }
    @Override
    public Ball generateBall(int position, NumberGenerator numberGenerator) {
        int randomNumber = numberGenerator.generate();
        return Ball.from(position, randomNumber);
    }

    @Override
    public List<Ball> generateBalls(NumberGenerator numberGenerator) {
        return IntStream.range(FIRST_POSITION_NUMBER, END_POSITION_NUMBER)
            .mapToObj(position -> generateBall(position, numberGenerator))
            .collect(Collectors.toList());
    }
}
