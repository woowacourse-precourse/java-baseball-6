package baseball.model.ball;

import baseball.model.Hint;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Balls {

    private List<Ball> balls = new ArrayList<>();

    public Balls(List<Integer> givenNumbers) {
        int position = 1;
        for (Integer number : givenNumbers) {
            this.balls.add(new Ball(position++, number));
        }
    }

    public BallStatus match(Ball targetBall) {
        return this.balls.stream()
            .map(ball -> ball.match(targetBall))
            .filter(ballStatus -> ballStatus != BallStatus.NOTHING)
            .findFirst()
            .orElse(BallStatus.NOTHING);
    }

    public Hint match(Balls givenBalls) {
        Hint hint = new Hint();
        for (Ball item : givenBalls.balls) {
            hint.report(this.match(item));
        }
        return hint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Balls givenBalls = (Balls) o;
        return Objects.equals(balls, givenBalls.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
