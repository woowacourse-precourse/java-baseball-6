package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class BallGenerator {
    private static final int COMPUTER_MAX_SIZE = 3;
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    private BallGenerator() {
    }

    private static class BallHolder {
        private static final BallGenerator INSTANCE = new BallGenerator();
    }

    public static BallGenerator getInstance() {
        return BallHolder.INSTANCE;
    }

    public String createRandomBall() {
        return String.valueOf(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
    }
}
