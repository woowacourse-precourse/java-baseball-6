package baseball.domain;

import baseball.constant.GameConstants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
    private final List<Integer> result;

    public Computer() {
        result = initResult();
    }

    public List<Integer> getResult() {
        return result;
    }

    private static List<Integer> initResult() {
        return Randoms.pickUniqueNumbersInRange(
                GameConstants.BALL_MIN_NUMBER, GameConstants.BALL_MAX_NUMBER, GameConstants.BALL_COUNT);
    }
}
