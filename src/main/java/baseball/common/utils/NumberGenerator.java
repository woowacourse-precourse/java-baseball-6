package baseball.common.utils;

import baseball.common.config.BaseballSystemConst;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public static List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < BaseballSystemConst.MAX_BALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(BaseballSystemConst.MIN_DIGIT_BALL,
                    BaseballSystemConst.MAX_DIGIT_BALL);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
