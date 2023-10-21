package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomBall {

    public static List<Integer> makeRandomBall() {
        List<Integer> ball = new ArrayList<>();
        while (ball.size() < 3) {
            int tempBall = Randoms.pickNumberInRange(1, 9);
            if (!ball.contains(tempBall)) {
                ball.add(tempBall);
            }
        }
        return ball;
    }
}
