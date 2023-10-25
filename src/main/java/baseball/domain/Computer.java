package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Computer {

    private static final int BALL_SIZE = 3;

    private final List<Integer> balls;

    Computer() {
        balls = new ArrayList<>();
    }

    void pickBalls() {
        balls.clear();
        while (balls.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!balls.contains(randomNumber)) {
                balls.add(randomNumber);
            }
        }
    }

    StrikeBallCount compare(Ball ball) {
        List<Integer> target = ball.balls();
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < BALL_SIZE; i++) {
            if (Objects.equals(balls.get(i), target.get(i))) {
                strikeCount++;
                continue;
            }

            if (target.contains(balls.get(i))) {
                ballCount++;
            }
        }
        return new StrikeBallCount(strikeCount, ballCount);
    }
}
