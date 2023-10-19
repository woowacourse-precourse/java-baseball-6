package baseball.domain;

import java.util.Objects;

public class BaseBallGameResult {

    private final int strikeCount;
    private final int ballCount;

    private BaseBallGameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static BaseBallGameResult of(int strikeCount, int ballCount) {
        return new BaseBallGameResult(strikeCount, ballCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBallGameResult that = (BaseBallGameResult) o;
        return strikeCount == that.strikeCount && ballCount == that.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

}
