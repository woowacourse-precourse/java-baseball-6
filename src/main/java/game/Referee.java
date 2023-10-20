package game;

import client.Ball;
import constants.NumberConstants;
import java.util.function.Function;

public class Referee {

    private static Ball computerBall;
    private static Ball playerBall;

    public static BallCounts judge(Ball computer, Ball player) {
        computerBall = computer;
        playerBall = player;
        int ball = countBall();
        int strike = countStrike();
        return new BallCounts(ball, strike);
    }

    private static int countBall() {
        int count = 0;
        for (int i = 0; i < NumberConstants.MAX_BALL_SIZE; i++) {
            count = increaseIf(
                    Referee::isBall,
                    i, count
            );
        }
        return count;
    }

    private static int increaseIf(Function<Integer, Boolean> func, int i, int count) {
        if (func.apply(i)) {
            count += 1;
        }
        return count;
    }

    private static boolean isBall(int i) {
        char number = playerBall.ballAt(i);
        return computerBall.ballAt(i) != number && computerBall.contains(number);
    }

    private static int countStrike() {
        int count = 0;
        for (int i = 0; i < NumberConstants.MAX_BALL_SIZE; i++) {
            count = increaseIf(
                    Referee::isStrike,
                    i, count
            );
        }
        return count;
    }

    private static boolean isStrike(int i) {
        return computerBall.ballAt(i) == playerBall.ballAt(i);
    }

}
