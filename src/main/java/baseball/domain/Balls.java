package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Integer> balls = new ArrayList<>();

    public void addBall(int ball) {
        balls.add(ball);
    }

    public boolean isSizeSame(int num) {
        return balls.size() == num;
    }

    public boolean isContain(int newBall) {

        for (int ball : balls) {
            if (ball == newBall) {
                return true;
            }
        }
        return false;
    }
}
