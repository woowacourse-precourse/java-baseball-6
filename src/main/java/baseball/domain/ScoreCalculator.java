package baseball.domain;

public class ScoreCalculator {
    public ScoreCalculator() {
    }

    public static Score createScore(BallNumber ballNumber1, BallNumber ballNumber2) {
        return new Score(calculateBall(ballNumber1, ballNumber2),
                calculateStrike(ballNumber1, ballNumber2));
    }
}
