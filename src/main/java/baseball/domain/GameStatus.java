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

    @Override
    public String toString() {
        return "GameStatus{" +
                "strikeCnt=" + strikeCnt +
                ", ballCnt=" + ballCnt +
                '}';
    }
}
