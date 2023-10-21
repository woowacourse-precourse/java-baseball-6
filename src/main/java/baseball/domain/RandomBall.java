package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomBall {
    private List<Integer> balls;

    public RandomBall() {
        this.balls = new ArrayList<>();
    }

    public void ballGenerator() {
        balls.clear();
        while (balls.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!balls.contains(randomNumber)) {
                balls.add(randomNumber);
            }
        }
    }

    public List<Integer> getBalls() {
        return this.balls;
    }
}
