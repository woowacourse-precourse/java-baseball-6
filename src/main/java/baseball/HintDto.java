package baseball;

public class HintDto {

    private int strike;
    private int ball;

    public void plusBall() {
        this.ball++;
    }

    public void plusStrike() {
        this.strike++;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }
}
