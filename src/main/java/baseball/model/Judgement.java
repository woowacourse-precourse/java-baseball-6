package baseball.model;

public class Judgement {

    private final Computer computer;
    private final Player player;

    private int strike;
    private int ball;

    public Judgement(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void judge() {
        strike = computer.countSamePlace(player);
        ball = computer.countSameNumber(player) - strike;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
