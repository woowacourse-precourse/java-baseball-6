package baseball.model;

public class GameScoreDTO {
    private int strike;
    private int ball;


    public GameScoreDTO() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getBall() {
        return ball;
    }

    public void setAddBall() {
        this.ball = this.ball+1;
    }

    public int getStrike() {
        return strike;
    }

    public void setAddStrike() {
        this.strike = this.strike+1;
    }
}
