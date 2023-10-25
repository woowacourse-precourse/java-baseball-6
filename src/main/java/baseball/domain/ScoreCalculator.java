package baseball.domain;

import baseball.SYSTEM_VALUE.GameStatusValue;
import java.util.stream.Stream;

public class ScoreCalculator {
    public ScoreCalculator() {
    }

    public static Score createScore(BallNumber ballNumber1, BallNumber ballNumber2) {
        return new Score(calculateBall(ballNumber1, ballNumber2),
                calculateStrike(ballNumber1, ballNumber2));
    }

    private static int calculateBall(BallNumber baseballNum1, BallNumber baseballNum2) {
        return (int) Stream.iterate(0, i -> i + 1)
                .limit(GameStatusValue.GAME_FINISH)
                .filter(i -> baseballNum2.contains(baseballNum1.getNumberAt(i)))
                .filter(i -> baseballNum1.getNumberAt(i) != baseballNum2.getNumberAt(i))
                .count();
    }

    private static int calculateStrike(BallNumber baseballNum1, BallNumber baseballNum2) {
        return (int) Stream.iterate(0, i -> i + 1)
                .limit(GameStatusValue.GAME_FINISH)
                .filter(i -> baseballNum1.getNumberAt(i) == baseballNum2.getNumberAt(i))
                .count();
    }
}
