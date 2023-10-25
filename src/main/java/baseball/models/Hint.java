package baseball.models;

public class Hint {

    private int ballCnt = 0;
    private int strikeCnt = 0;

    public Hint(int ballCnt, int strikeCnt) {
        this.ballCnt = ballCnt;
        this.strikeCnt = strikeCnt;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    @Override
    public String toString() {
        if (ballCnt > 0 && strikeCnt > 0) {
            return ballCnt + "볼 " + strikeCnt + "스트라이크";
        } else if (ballCnt > 0 && strikeCnt == 0) {
            return ballCnt + "볼";
        } else if (ballCnt == 0 && strikeCnt > 0) {
            return strikeCnt + "스트라이크";
        } else {
            return "낫싱";
        }
    }

}
