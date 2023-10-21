package baseball.model.judge;

public class StrikeCount {

    private final int count;

    public StrikeCount(int count) {
        this.count = count;
    }

    public static StrikeCount noCount() {
        return new StrikeCount(0);
    }

    public boolean isZero() {
        return this.count == 0;
    }

}
