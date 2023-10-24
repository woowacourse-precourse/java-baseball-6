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

    public void judge(Balls userBalls, Balls computerBalls) {
        for (int i = 0; i < 3; i++) {
            judgeBall(i, userBalls, computerBalls);
        }
    }

    private void judgeBall(int i, Balls userBalls, Balls computerBalls) {
        Ball userBall = userBalls.get(i);
        Ball computerBall = computerBalls.get(i);
        if (computerBall.equals(userBall)) {
            strikeCount++;
            return;
        }
        if (computerBalls.containsBallValue(userBall)){
            ballCount++;
        }
    }
}