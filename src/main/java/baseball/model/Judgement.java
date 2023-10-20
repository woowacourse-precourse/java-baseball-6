package baseball.model;

public class Judgement {

    private int ball;
    private int strike;

    public void judge(Computer computer, Player player) {
        strike = player.countSameIndex(computer);
        ball = player.countSameNumber(computer) - strike;
    }

    public boolean isAllStrike() {
        return strike == 3;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
