package baseball.vo;

public class Score {

    int ball;
    int strike;

    public Score(int ball) {
        this.ball = ball;
    }

    public void increaseStrike(int strikeCnt){
        this.strike = strikeCnt;
        this.ball -= strikeCnt;
    }
}
