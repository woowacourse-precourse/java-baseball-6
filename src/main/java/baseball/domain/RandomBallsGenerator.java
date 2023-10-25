package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomBallsGenerator implements BallsGenerator {

    private static final int FIRST_POSITION_NUMBER = 1;
    private static final int END_POSITION_NUMBER = 4;
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
    public List<Ball> generateBalls() {
        return IntStream.range(FIRST_POSITION_NUMBER, END_POSITION_NUMBER)
            .mapToObj(this::generateBall)
            .collect(Collectors.toList());
    }
}
