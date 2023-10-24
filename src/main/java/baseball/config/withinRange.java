package baseball.config;

public record withinRange(int startInclusive, int endInclusive) {

    @Override
    public int startInclusive() {
        return startInclusive;
    }

    @Override
    public int endInclusive() {
        return endInclusive;
    }
}
