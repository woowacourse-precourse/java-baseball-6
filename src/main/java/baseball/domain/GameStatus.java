package baseball.domain;

public class GameStatus {

    private int strikeCnt;
    private int ballCnt;

    public GameStatus() {
        reset();
    }

    public void updateStrikeCnt(int strikeCnt) {
        this.strikeCnt = strikeCnt;
    }

    public void updateBallCnt(int ballCount) {
        this.ballCnt = ballCount;
    }

    public boolean isEnd() {
        return this.strikeCnt == GameNumberSet.NUMBER_LENGTH;
    }

    public boolean isNotEnd() {
        return this.strikeCnt != GameNumberSet.NUMBER_LENGTH;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public void reset() {
        strikeCnt = 0;
        ballCnt = 0;
    }

    public boolean isNotBallCntZero() {
        return this.ballCnt != 0;
    }

    public boolean isNotStrikeCntZero() {
        return this.strikeCnt != 0;
    }

    public boolean isNothing() {
        return strikeCnt == 0 && ballCnt == 0;
    }
}
