package baseball;

public class BallStatusRecord {

    private int ballCount;
    private int strikeCount;

    public BallStatusRecord() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public void record(BallStatus status) {
        if (status == BallStatus.STRIKE) {
            this.strikeCount += 1;
        } else if (status == BallStatus.BALL) {
            this.ballCount += 1;
        }
    }

    public String getResult() {
        if (ballCount != 0 && strikeCount != 0) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        } else if (ballCount != 0) {
            return ballCount + "볼";
        } else if (strikeCount != 0) {
            return strikeCount + "스트라이크";
        }
        return "낫싱";
    }
}
