package game;

import client.Ball;

public class Computer {

    private final Ball ball;
    private BallCounts ballCounts;

    public Computer() {
        ball = new Ball(getRandomNumbers());
        ballCounts = new BallCounts();
    }

    public void judge(Ball playerBall) {
        ballCounts = Referee.judge(ball, playerBall);
    }

    private String getRandomNumbers() {
        return RandomNumbersGenerator.getRandomNumbers();
    }

    public boolean isFinish() {
        return ballCounts.isFinish();
    }
}
