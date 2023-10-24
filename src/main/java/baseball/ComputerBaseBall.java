package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerBaseBall {
    private List<Ball> balls;

    public ComputerBaseBall() {
        this.balls = createBaseBall();
    }

    private List<Ball> createBaseBall() {
        List<Ball> createBalls = new ArrayList<>();
        while (createBalls.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            Ball createBall = new Ball(String.valueOf(randomNumber));
            if (!createBalls.contains(createBall)) {
                createBalls.add(createBall);
            }
        }
        return createBalls;
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }
}
