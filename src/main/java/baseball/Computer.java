package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> balls = new ArrayList<>();

    public Computer() {
    }

    public void selectBalls() {
        for (int i = 0; i < 3; i++) {
            int num = pickNumberInRange(0, 9);

            if (balls.contains(num)) {
                i--;
                continue;
            }
            balls.add(num);
        }
    }
}
