package baseball;

public class Score {
    private int strikeCnt = 0;
    private int ballCnt = 0;

    public Score(int strikeCnt, int ballCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public void setStrikeCnt(int strikeCnt) {
        this.strikeCnt = strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public void setBallCnt(int ballCnt) {
        this.ballCnt = ballCnt;
    }

    public boolean isSame() {
        if (strikeCnt == 3)
            return true;
        return false;
    }

    public boolean isDiff() {
        if (strikeCnt == 0 && ballCnt == 0)
            return true;
        return false;
    }
}
