package baseball.domain.game;

import static baseball.global.message.BallMessage.*;

public class PlayResult {
    private int ballCnt;
    private int strikeCnt;

    public PlayResult() {
        this.ballCnt = 0;
        this.strikeCnt = 0;
    }

    public void clearResult() {
        this.ballCnt = 0;
        this.strikeCnt = 0;
    }

    public void plusBallCnt() {
        this.ballCnt++;
    }
    public void plusStrikeCnt() {
        this.strikeCnt++;
    }

    public String returnResult() {
        if(ballCnt > 0 && strikeCnt > 0) {
            return BALL.apply(ballCnt) + " " +STRIKE.apply(strikeCnt);
        }
        if(ballCnt == 0 && strikeCnt > 0) {
            return STRIKE.apply(strikeCnt);
        }
        if(ballCnt > 0 && strikeCnt == 0) {
            return BALL.apply(ballCnt);
        }
        else {
            return NOTHING.getMessage();
        }
    }

}
