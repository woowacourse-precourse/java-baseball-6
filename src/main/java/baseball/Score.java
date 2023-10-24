package baseball;


import static baseball.SystemConstant.GAME_DIGIT;

public class Score {

    private final int ball;

    private final int strike;

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

    public boolean isGameOver(){
        return strike == GAME_DIGIT;
    }

    public boolean isZeroPoint(){
        return ball == 0 && strike == 0;
    }
}
