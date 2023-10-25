package baseball.util.random;

public class Range {

    private final int startInclusive;
    private final int endInclusive;

    public Range(int startInclusive, int endInclusive) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    protected int startInclusive() {
        return startInclusive;
    }

    protected int endInclusive() {
        return endInclusive;
    }
}
