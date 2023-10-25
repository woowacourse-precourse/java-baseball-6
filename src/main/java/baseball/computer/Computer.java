package baseball.computer;

import baseball.game.Ball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public Ball balls;

    public void initializeBall() {
        List<Integer> randomBalls = new ArrayList<>();
        while (randomBalls.size() < 3) {
            int randomBall = Randoms.pickNumberInRange(1, 9);
            if (!randomBalls.contains(randomBall)) {
                randomBalls.add(randomBall);
            }
        }

        balls = new Ball(randomBalls);
    }
}
