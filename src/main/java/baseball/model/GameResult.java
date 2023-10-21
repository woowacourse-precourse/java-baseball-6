package baseball.model;

public class GameResult {
    private int strike;
    private int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isSuccess() {
        if(strike == 3 && ball == 0) {
            return true;
        }

         return false;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
