package baseball.domain;

public record RoundResult(
        int strikeCount,
        int ballCount
) {
    public boolean isClear() {
        return strikeCount == Baseball.TOTAL_COUNT;
    }
}
