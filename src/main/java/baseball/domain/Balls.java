package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Integer> balls = new ArrayList<>();

    public void addBall(int ball) {
        balls.add(ball);
    }

}
