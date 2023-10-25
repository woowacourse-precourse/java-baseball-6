package baseball.domain;

import java.util.Objects;

public class Result {
    private int ballCount;
    private int strikeCount;

    public Result(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Result result = (Result) obj;
        return ballCount == result.ballCount && strikeCount == result.strikeCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballCount, strikeCount);
    }
}
