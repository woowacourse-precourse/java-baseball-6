package game;

import baseball.Output;
import client.Ball;

public class Computer {

    private final Ball ball;
    private BallCounts ballCounts;

    public Computer() {
        ball = new Ball(getRandomNumbers());
        ballCounts = new BallCounts();
    }

    public void catchBall(Ball playerBall) {
        ballCounts = judge(playerBall);
        Output.printMessage(ballCounts.toString());
    }

    public BallCounts judge(Ball playerBall) {
        return Referee.judge(ball, playerBall);
    }

    private String getRandomNumbers() {
        return RandomNumbersGenerator.getRandomNumbers();
    }

    public boolean isFinish() {
        return ballCounts.isFinish();
    }
}
