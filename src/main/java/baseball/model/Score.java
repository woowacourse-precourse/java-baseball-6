package baseball.model;

public class Score {
    // 볼 개수
    private int ball;
    // 스트라이크 개수
    private int strike;

    public Score(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
