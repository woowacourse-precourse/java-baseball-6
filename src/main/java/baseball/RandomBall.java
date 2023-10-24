package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomBall {

    private static final int NUM_OF_BALLS = 3;

    /**
     * 무작위로 1에서 9 사이의 서로 다른 3개의 숫자로 이루어진 리스트를 생성합니다.
     *
     * @return 무작위로 생성된 3개의 숫자로 이루어진 리스트
     */

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
