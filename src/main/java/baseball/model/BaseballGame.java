package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {




    public BaseballGame() {

    }

    public int makeRandomNumber() {
        return Randoms.pickNumberInRange(RangeConstant.START_INT, RangeConstant.END_INT);
    }
}
