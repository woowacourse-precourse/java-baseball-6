package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomBall {

    private static final int NUM_OF_BALLS = 3;

    protected static List<Integer> makeRandomBall() {
        List<Integer> ball = new ArrayList<>();
        while (ball.size() < NUM_OF_BALLS) {
            int tempBall = Randoms.pickNumberInRange(1, 9);
            if (!ball.contains(tempBall)) {
                ball.add(tempBall);
            }
        }
        return ball;
    }
}
