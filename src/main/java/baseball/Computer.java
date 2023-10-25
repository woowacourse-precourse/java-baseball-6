package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> balls;

    public Computer() {
    }

    public void selectBalls() {
        balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = pickNumberInRange(1, 9);

            if (balls.contains(num)) {
                i--;
                continue;
            }
            balls.add(num);
        }
    }

    public List<Integer> getBalls() {
        return balls;
    }
}
