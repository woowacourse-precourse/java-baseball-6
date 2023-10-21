package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomBallsGenerator implements BallsGenerator {

    private static final int BALL_COUNT = 3;

    @Override
    public List<Ball> generate(NumberGenerator numberGenerator) {
        List<Ball> answerBalls = new ArrayList<>();
        for (int position = 1; position <= BALL_COUNT; position++) {
            int randomNumber = numberGenerator.generate();
            Ball answerBall = new Ball(position, randomNumber);
            answerBalls.add(answerBall);
        }
        return answerBalls;
    }

    @Override
    public List<Ball> generate(Ball... balls) {
        return Arrays.asList(balls);
    }
}
