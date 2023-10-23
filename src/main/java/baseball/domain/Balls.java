package baseball.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public Referee play(Balls playerBalls) {
        List<Ball> ballsList = playerBalls.getBalls();
        List<BallStatus> ballStatuses = ballsList.stream().map(this::match).collect(Collectors.toList());
        return new Referee(ballStatuses);
    }

    private BallStatus match(Ball playerBall) {
        return this.balls.stream()
                .map(ball -> ball.play(playerBall)).filter(ballStatus -> !ballStatus.equals(BallStatus.NOTHING))
                .findAny()
                .orElse(BallStatus.NOTHING);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls1 = (Balls) o;
        return Objects.equals(balls, balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}