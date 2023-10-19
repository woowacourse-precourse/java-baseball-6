package baseball.service;

import baseball.common.Size;

import camp.nextstep.edu.missionutils.Randoms;

public class BallGenerator {
    public int createBall() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Size.NUMBER.getValue(); i++) {
            result.append(Randoms.pickNumberInRange(Size.MIN.getValue(), Size.MAX.getValue()));
        }
        return Integer.parseInt(result.toString());
    }
}
