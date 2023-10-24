package baseball.domain;

import static baseball.domain.BallStatus.BALL;
import static baseball.domain.BallStatus.NOTHING;
import static baseball.domain.BallStatus.STRIKE;

import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    private final List<BallNumber> balls;

    public Balls(List<Integer> numbers) {
        this.balls = numbers.stream()
            .map(BallNumber::new)
            .collect(Collectors.toList());
    }

    public int compare(BallNumber ball, int i) {
        if (balls.get(i).equals(ball)) {
            return STRIKE.getValue();
        }
        if (balls.contains(ball)) {
            return BALL.getValue();
        }
        return NOTHING.getValue();
    }
}
