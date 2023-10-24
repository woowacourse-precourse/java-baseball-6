package baseball.player;

import baseball.Ball;
import java.util.List;

public class Player {
    private Ball balls;

    public void throwBalls(List<Integer> ball) {
        balls = new Ball(ball);
    }
}
