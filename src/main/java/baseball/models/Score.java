package baseball.models;

public class Score {

    private int strikeCnt;
    private int ballCnt;

    public Score() { // 생성
        this.strikeCnt = 0;
        this.ballCnt = 0;
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
}
