package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {

    private static final int START_INT = 100;
    private static final int END_INT = 999;


    public BaseballGame() {

    }

    public int makeRandomNumber() {
        return Randoms.pickNumberInRange(START_INT, END_INT);
    }
}
