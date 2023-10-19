package baseball.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> ballNumbers) {
        this.balls = mapToBalls(ballNumbers);
    }

    private List<Ball> mapToBalls(List<Integer> ballNumbers) {
        AtomicInteger idx = new AtomicInteger(1);
        return ballNumbers.stream()
                .map(number -> new Ball(new Position(idx.getAndIncrement()), new BallNum(number)))
                .collect(Collectors.toList());
    }

    public BallStatus match(Ball userBall) {
        return balls.stream()
                .map(ball -> ball.match(userBall))
                .filter(status -> !status.equals(BallStatus.NOTHING))
                .findAny()
                .orElse(BallStatus.NOTHING);
    }

    public List<BallStatus> play(List<Integer> userBallNumbers) {
        List<Ball> userBalls = mapToBalls(userBallNumbers);

        List<BallStatus> ballStatuses = userBalls.stream()
                .map(userBall -> this.match(userBall))
                .collect(Collectors.toList());

        return ballStatuses;
    }
}
