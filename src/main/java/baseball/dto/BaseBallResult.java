package baseball;

public class BaseBallResult {
    private int strikeCnt;
    private int ballCnt;
    private boolean isNothing;

    public BaseBallResult(int strikeCnt, int ballCnt, boolean isNothing) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
        this.isNothing = isNothing;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public boolean isNothing() {
        return isNothing;
    }
}
