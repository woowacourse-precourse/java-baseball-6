package baseball.domain.role;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomBallPicker implements BallPicker {
    @Override
    public int pickNumberInRange(int minValues, int maxValues) {
        return Randoms.pickNumberInRange(minValues, maxValues);
    }
}