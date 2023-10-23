package baseball.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class Balls {

    private static final int BALL_COUNT = 3;
    private static final String DUPLICATES_EXCEPTION_MESSAGE = "[ERROR] 중복되지 않는 3자리의 숫자를 입력해주세요.";
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
            throw new IllegalArgumentException(DUPLICATES_EXCEPTION_MESSAGE);
        }
    }

    private boolean hasDuplicatesInList(List<Ball> ballList) {
        int uniqueBallCount = (int) ballList.stream()
            .distinct()
            .count();
        return uniqueBallCount < BALL_COUNT;
    }

    public GameResult getTryResultList(Balls playerBalls) {
        return balls.stream()   // balls = answerBalls
            .map(playerBalls::getTryResult)
            .collect(collectingAndThen(toList(), GameResult::from));
    }

    private TryResult getTryResult(Ball answerBall) {
        return balls.stream()   // balls = playerBalls
            .map(playerBall -> playerBall.getTryResult(answerBall))
            .filter(tryResult -> tryResult != TryResult.NOTHING)
            .findFirst()
            .orElse(TryResult.NOTHING);
    }

    public static Balls from(List<Ball> balls) {
        return new Balls(balls);
    }
}
