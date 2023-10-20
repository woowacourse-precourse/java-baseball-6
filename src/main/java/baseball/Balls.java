package baseball;

import java.util.Arrays;
import java.util.List;

public class Balls {

    private static final int BALL_COUNT = 3;
    private final List<Ball> balls;

    public Balls(List<Ball> ballList) {
        this.balls = ballList;
    }

    public Balls(Ball... ballValues) {
        balls = Arrays.asList(ballValues);
    }

    public void validateSize(List<Ball> ballList) {
        if (!hasThreeDigits(ballList)) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }
    }

    public void valdateDuplicates(List<Ball> ballList) {
        if (hasDuplicatesInList(ballList)) {
            throw new IllegalArgumentException("중복되지 않는 3자리의 숫자를 입력해주세요.");
        }
    }

    private boolean hasThreeDigits(List<Ball> ballList) {
        return ballList.size() == BALL_COUNT;
    }

    private boolean hasDuplicatesInList(List<Ball> ballList) {
        int uniqueBallCount = (int) ballList.stream()
            .distinct()
            .count();

        return uniqueBallCount < BALL_COUNT;
    }

    public int getStrikeCount(Balls answerBalls) {
        return (int) balls.stream()
            .map(playerBall -> getTryResult(playerBall, answerBalls))
            .filter(tryResult -> tryResult == TryResult.STRIKE)
            .count();
    }

    public int getBallCount(Balls answerBalls) {
        return (int) balls.stream()
            .map(playerBall -> getTryResult(playerBall, answerBalls))
            .filter(tryResult -> tryResult == TryResult.BALL)
            .count();
    }

    private TryResult getTryResult(Ball playerBall, Balls answerBalls) {
        if (isStrike(playerBall, answerBalls)) {
            return TryResult.STRIKE;
        }
        if (isBall(playerBall, answerBalls)) {
            return TryResult.BALL;
        }
        return TryResult.NOTHING;
    }

    private boolean isBall(Ball playerBall, Balls answerBalls) {
        return answerBalls.containsNumber(playerBall);
    }

    private boolean containsNumber(Ball playerBall) {
        return balls.stream()
            .anyMatch(answerBall -> answerBall.isSameNumber(playerBall));
    }

    private boolean isStrike(Ball playerBall, Balls answerBalls) {
        return answerBalls.contains(playerBall);
    }

    private boolean contains(Ball playerBall) {
        return balls.contains(playerBall);
    }

    public static Balls from(List<Ball> balls) {
        return new Balls(balls);
    }
}
