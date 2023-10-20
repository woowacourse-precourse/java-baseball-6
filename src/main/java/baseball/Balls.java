package baseball;

import java.util.Arrays;
import java.util.List;

public class Balls {

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
        return ballList.size() == 3;
    }

    private boolean hasDuplicatesInList(List<Ball> ballList) {
        int uniqueBallCount = (int) ballList.stream()
            .distinct()
            .count();

        return uniqueBallCount < 3;
    }

    public int getStrikeCount(Balls answerBalls) {
        return (int) balls.stream()
            .map(ball -> getTryResult(ball, answerBalls))
            .filter(tryResult -> tryResult == TryResult.STRIKE)
            .count();
    }

    private TryResult getTryResult(Ball ball, Balls answerBalls) {
        if (isStrike(ball, answerBalls)) {
            return TryResult.STRIKE;
        }
        return null;
    }

    private boolean isStrike(Ball ball, Balls answerBalls) {
        return answerBalls.contains(ball);
    }

    private boolean contains(Ball ball) {
        return balls.contains(ball);
    }
}
