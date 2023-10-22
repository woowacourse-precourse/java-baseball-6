package baseball;

public class MatchResult {
    final Integer ballCount;
    final Integer strikeCount;
    final Boolean isNothing;

    public MatchResult(final int ballCount, final int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
        if (ballCount > 0 || strikeCount > 0) {
            isNothing = false;
        } else {
            isNothing = true;
        }
    }
}
