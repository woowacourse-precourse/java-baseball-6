package baseball.player;

import baseball.Ball;
import java.util.List;

public class Player {
    private Ball balls;

    public Player(List<Integer> ball) {
        balls = new Ball(ball);
    }
}
