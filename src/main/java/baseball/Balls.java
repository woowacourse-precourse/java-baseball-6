package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Integer> balls;

    public Balls() {
        createRandomNumbers();
    }

    private void createRandomNumbers() {
        balls = new ArrayList<>();

        while (balls.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!balls.contains(number)) {
                balls.add(number);
            }
        }
    }
}
