package baseball.model;

public class Judgement {

    private static final int MAX_STRIKE_COUNT = 3;

    private final Computer computer;

    private int strike;
    private int ball;

    public Judgement(Computer computer) {
        this.computer = computer;
    }

    public void judge(Player player) {
        strike = computer.countSamePlace(player);
        ball = computer.countSameNumber(player) - strike;
    }

    public boolean isProgress() {
        return strike < MAX_STRIKE_COUNT;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
