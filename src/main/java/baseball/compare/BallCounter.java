package baseball.compare;

import baseball.balls.Balls;

public class BallCounter {
    private final Integer MAX_CAPACITY = 3;
    private int ballCountStatus = 0;
    private int arrayIndexStatus = 0;

    public int ballCount(Balls answerBalls, Balls playerBalls) {
        int playerBall = playerBalls.getBallsList().get(arrayIndexStatus);
        int answerBall = answerBalls.getBallsList().get(arrayIndexStatus);
        if (answerBalls.getBallsList().contains(playerBall) && answerBall != playerBall) {
            ballCountStatus = ballCountStatus + 1;
        }
        arrayIndexStatus = arrayIndexStatus + 1;
        if (arrayIndexStatus != MAX_CAPACITY){
            return ballCount(answerBalls, playerBalls);
        }
        return ballCountStatus;
    }
}
