package judge;

import ball.Ball;
import ball.Balls;

public class Judge {
    private int strikeCount;
    private int ballCount;
    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void compareBalls(Balls userBalls, Balls computerBalls) {
        initializeCounts();
        for (int i = 0; i < 3; i++) {
            compareBall(i, userBalls, computerBalls);
        }
    }

    public boolean isCorrect() {
        return this.strikeCount == 3;
    }

    private void initializeCounts() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    private void compareBall(int i, Balls userBalls, Balls computerBalls) {
        Ball userBall = userBalls.get(i);
        Ball computerBall = computerBalls.get(i);
        if (computerBall.equals(userBall)) {
            this.strikeCount++;
            return;
        }
        if (computerBalls.containsBallValue(userBall)) {
            this.ballCount++;
        }
    }
}
