package baseball.domain.player.value;

import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public Ball getBall(int index) {
        return balls.get(index);
    }

    public Long size() {
        return (long) balls.size();
    }

    public boolean isContain(Ball ball) {
        return balls.contains(ball);
    }

    public boolean isSame(Ball ball, Long index) {
        if (index < 0 || index >= balls.size()) {
            return false;
        }
        return balls.get(index.intValue()).equals(ball);
    }
}
