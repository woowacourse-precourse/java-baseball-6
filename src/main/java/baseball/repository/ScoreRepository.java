package baseball.repository;

public class ScoreRepository {
    private int ball;
    private int strike;

    public ScoreRepository() {
        this.ball = 0;
        this.strike = 0;
    }


    public int getBall() {
        return ball;
    }

    public void increaseBall() {
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public void increaseStrike() {
        strike++;
    }
}
