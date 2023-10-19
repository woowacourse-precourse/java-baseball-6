package baseball.service;

import baseball.common.Size;

import camp.nextstep.edu.missionutils.Randoms;

public class BallGenerator {
    public int createBall() {
        StringBuilder result = new StringBuilder();
        while (result.length() < Size.NUMBER.getValue()) {
            int add = Randoms.pickNumberInRange(Size.MIN.getValue(), Size.MAX.getValue());
            if (!result.toString().contains(Integer.toString(add))) {
                result.append(add);
            }
        }
        return Integer.parseInt(result.toString());
    }
}
