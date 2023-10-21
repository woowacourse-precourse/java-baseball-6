package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    private static final int BALL_COUNT = 3;
    private final List<Ball> balls;

    public Balls(List<Ball> ballList) {
        valdateDuplicates(ballList);
        this.balls = ballList;
    }

    public Balls(Ball... ballValues) {
        balls = Arrays.asList(ballValues);
    }

    public void valdateDuplicates(List<Ball> ballList) {
        if (hasDuplicatesInList(ballList)) {
            throw new IllegalArgumentException("중복되지 않는 3자리의 숫자를 입력해주세요.");
        }
    }

    private boolean hasDuplicatesInList(List<Ball> ballList) {
        int uniqueBallCount = (int) ballList.stream()
            .distinct()
            .count();
        return uniqueBallCount < BALL_COUNT;
    }

    public List<TryResult> getTryResultList(Balls answerBalls) {
        return balls.stream()   // balls = playerBalls
            .map(answerBalls::getTryResult)
            .collect(Collectors.toList());
    }

    private TryResult getTryResult(Ball playerBall) {
        return balls.stream()   // balls = answerBalls
            .map(answerBall -> answerBall.getTryResult(playerBall))
            .findFirst()
            .orElse(TryResult.NOTHING);
    }

    public static Balls from(List<Ball> balls) {
        return new Balls(balls);
    }
}
