package baseball.vo;

public class Score {

    private static final int GAME_ANSWER_VALUE = 3;
    int ball;
    int strike;

    public Score(int ball) {
        this.ball = ball;
    }

    public void increaseStrike(int strikeCnt){
        this.strike = strikeCnt;
        this.ball -= strikeCnt;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isAnswer() {
        return this.strike == GAME_ANSWER_VALUE;
    }
}
