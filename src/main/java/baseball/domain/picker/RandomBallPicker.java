package baseball.domain.picker;

import baseball.domain.ball.Ball;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomBallPicker implements BallPicker {
    @Override
    public Ball pickNumberInRange(int minValues, int maxValues) {
        return new Ball(Randoms.pickNumberInRange(minValues, maxValues));
    }
}