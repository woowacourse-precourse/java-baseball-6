package baseball.util;

import baseball.domain.Balls;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.common.Constants.*;

public class RandomNumberUtil {
    public static Balls makeRandomComputerBalls() {
        List<Integer> randomBalls = new ArrayList<>();
        while (randomBalls.size() < BALL_CNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!randomBalls.contains(randomNumber)) {
                randomBalls.add(randomNumber);
            }
        }
        return new Balls(randomBalls);
    }
}
