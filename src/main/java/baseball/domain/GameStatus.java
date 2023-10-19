package baseball.domain;

public class GameStatus {

    private int strikeCnt;
    private int ballCnt;

    public void updateStrikeCnt(int strikeCnt) {
        this.strikeCnt = strikeCnt;
    }

    public void updateBallCnt(int ballCount) {
        this.ballCnt = ballCount;
    }

    public boolean isEnd() {
        return this.strikeCnt == 3;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }
}
