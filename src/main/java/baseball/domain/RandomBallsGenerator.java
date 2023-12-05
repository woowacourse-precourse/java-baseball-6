package baseball.domain;

import static baseball.domain.Constant.UPPER_BALL_POSITION;
import static baseball.domain.Constant.START_BALL_POSITION;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.stream.IntStream;

public class RandomBallsGenerator implements BallsGenerator {

    private final NumberGenerator numberGenerator;

    public RandomBallsGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public static BallsGenerator init(NumberGenerator numberGenerator) {
        return new RandomBallsGenerator(numberGenerator);
    }
    @Override
    public Ball generateBall(int position) {
        int randomNumber = numberGenerator.generate();
        return Ball.from(position, randomNumber);
    }

    @Override
    public Balls generateBalls() {
        return IntStream.range(START_BALL_POSITION, UPPER_BALL_POSITION)
            .mapToObj(this::generateBall)
            .collect(collectingAndThen(toList(), Balls::from));
    }
}
