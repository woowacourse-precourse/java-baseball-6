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
            int num = pickNumberInRange(0, 9);

            if (balls.contains(num)) {
                i--;
                continue;
            }
            balls.add(num);
        }
        for (int i : balls) {
            System.out.println(i); //////////
        }
    }

    public List<Integer> getBalls() {
        return balls;
    }
}
