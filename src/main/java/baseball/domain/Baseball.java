package baseball.domain;

public class Baseball {
    private int ball;
    private int strike;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void initGame() {
        ball = 0;
        strike = 0;
    }

    public void ballCntUp() {
        ball += 1;
    }

    public void strikeCntUp() {
        strike += 1;
    }
}
