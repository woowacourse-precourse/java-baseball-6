package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final List<Integer> balls = new ArrayList<>();

    private static final int BALLS_SIZE = 3;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;

    public void chooseBalls() {
        clearBalls();

        while (balls.size() < BALLS_SIZE) {
            int ball = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);

            if (!balls.contains(ball)) {
                balls.add(ball);
            }
        }
    }

    public List<Integer> getBalls() {
        return balls;
    }

    public int getBall(int i) {
        return balls.get(i);
    }

    public void clearBalls() {
        balls.clear();
    }
}
