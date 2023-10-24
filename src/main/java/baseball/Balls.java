package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Balls {
    private static final int BALL_COUNT = 3;
    private static final int NOT_FOUND_INDEX = -1;
    private static final String DUPLICATE_BALL_MESSAGE = "중복된 값이 있습니다.";
    private List<Ball> balls = new ArrayList<>();

    public Balls() {
        createRandomBalls();
    }

    public Balls(Ball firstBall, Ball secondBall, Ball thirdBall) {
        isDuplication(firstBall, secondBall, thirdBall);
        balls.add(firstBall);
        balls.add(secondBall);
        balls.add(thirdBall);
    }

    private void isDuplication(Ball firstBall, Ball secondBall, Ball thirdBall) {
        if (firstBall.equals(secondBall)
                || firstBall.equals(thirdBall)
                || secondBall.equals(thirdBall)) {
            throw new IllegalArgumentException(DUPLICATE_BALL_MESSAGE);
        }
    }

    private void createRandomBalls() {
        balls = new ArrayList<>();

        while (balls.size() < BALL_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(Ball.MIN_VALUE, Ball.MAX_VALUE);
            Ball randomBall = new Ball(randomNumber);
            if (indexOf(randomBall) == NOT_FOUND_INDEX) {
                balls.add(randomBall);
            }
        }
    }

    public GameResult getGameResult(Balls targetBalls) {
        GameResult result = new GameResult();

        for (int i = 0; i < balls.size(); i++) {
            int searchIndex = targetBalls.indexOf(balls.get(i));
            result.checkBallIndex(i, searchIndex);
        }

        return result;
    }

    private int indexOf(Ball targetBall) {
        for (int i = 0; i < balls.size(); i++) {
            Ball ball = balls.get(i);
            if (ball.equals(targetBall)) {
                return i;
            }
        }
        return NOT_FOUND_INDEX;
    }
}
