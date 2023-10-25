package baseball.config;

public record WithinRange(int startInclusive, int endInclusive) {

    @Override
    public int startInclusive() {
        return startInclusive;
    }

    @Override
    public int endInclusive() {
        return endInclusive;
    }
}
