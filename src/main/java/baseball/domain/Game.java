package baseball.domain;

public class Game {
    private int[] answer;
    private int strike;
    private int ball;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void increaseBall() {
        this.ball++;
    }

    public void  increaseStrike() {
        this.strike++;
    }
}
