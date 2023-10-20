package baseball.model;

public class Judgement {

    private int ball;
    private int strike;

    public void judge(Computer computer, Player player) {
        strike = player.countSameIndex(computer);
        ball = player.countSameNumber(computer) - strike;
    }
}
