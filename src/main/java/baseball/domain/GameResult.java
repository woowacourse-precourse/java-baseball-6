package baseball.domain;

public class GameResult {

    private final int strikeCnt;
    private final int ballCnt;

    public GameResult(int strikeCnt, int ballCnt) {
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
