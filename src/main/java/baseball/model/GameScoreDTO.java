package baseball.model;

public class GameScoreDTO {
    private int strike;
    private int ball;
    private  boolean isGameOver;


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

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.isGameOver = gameOver;
    }
}
