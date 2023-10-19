package baseball.domain;

import static baseball.utils.Constants.MAX_NUMBER;
import static baseball.utils.Constants.MIN_NUMBER;
import static baseball.utils.Constants.NUMBER_OF_BALLS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomBallsGenerator implements BallsGenerator {
    public final List<Integer> balls = new ArrayList<>();

    public Balls generateBalls() {
        while (balls.size() < NUMBER_OF_BALLS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!balls.contains(randomNumber)) {
                balls.add(randomNumber);
            }
        }
        return Balls.from(balls);
    }
}
