package baseball.domain.ball;

public enum BallKind {
    BALL,
    STRIKE;

    public String toStringWithCount(final int count) {
        return count + switch (this) {
            case BALL -> "볼 ";
            case STRIKE -> "스트라이크";
        };
    }
}
