package baseball.domain.balls;

import static baseball.utils.Constants.MAX_NUMBER;
import static baseball.utils.Constants.MIN_NUMBER;
import static baseball.utils.Constants.NUMBER_OF_BALLS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomBallsGenerator implements BallsGenerator {
    public final List<Integer> balls = new ArrayList<>();

    @Override
    public Balls generateBalls() {
        balls.clear();
        addBalls();
        return Balls.from(balls);
    }

    private void addBalls() {
        while (balls.size() < NUMBER_OF_BALLS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!balls.contains(randomNumber)) {
                balls.add(randomNumber);
            }
        }
    }
}
