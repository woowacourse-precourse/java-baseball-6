package baseball.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Balls {

    private final List<Ball> balls;

    private Balls(List<Ball> ballList) {
        this.balls = ballList;
    }

    public GameResult getTryResultList(Balls playerBalls) {
        return balls.stream()   // balls = answerBalls
            .map(playerBalls::getTryResult)
            .collect(collectingAndThen(toList(), GameResult::from));
    }

    private TryResult getTryResult(Ball answerBall) {
        return balls.stream()   // balls = playerBalls
            .map(playerBall -> playerBall.getTryResult(answerBall))
            .filter(isNotNothing())
            .findFirst()
            .orElse(TryResult.NOTHING);
    }

    private static Predicate<TryResult> isNotNothing() {
        return tryResult -> tryResult != TryResult.NOTHING;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public static Balls from(List<Ball> balls) {
        return new Balls(balls);
    }
}
