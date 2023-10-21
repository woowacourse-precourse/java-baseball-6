package baseball.model.judge;

public class BallCount {

    private final int count;

    public BallCount(int count) {
        this.count = count;
    }

    public static BallCount noCount() {
        return new BallCount(0);
    }

    public boolean isZero() {
        return this.count == 0;
    }

}
