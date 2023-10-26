package baseball.model;

public class Judgement {

    private static final int ZERO = 0;
    private static final int MAX_COUNT = 3;

    private int ball;
    private int strike;

    public void judge(Computer computer, Player player) {
        strike = player.countSameIndex(computer);
        ball = player.countSameNumber(computer) - strike;
    }

    public boolean isAllStrike() {
        return strike == MAX_COUNT;
    }

    public boolean hasStrike() {
        return ZERO < strike;
    }

    public boolean hasBall() {
        return ZERO < ball;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
