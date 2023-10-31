package baseball.dto;

public class StrikeBallCnt {

    private int strikeCnt;
    private int ballCnt;

    public StrikeBallCnt(int strikeCnt, int ballCnt){
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }
}
