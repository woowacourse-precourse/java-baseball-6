package baseball.game.entity;

import java.util.Objects;

public class GameScore {
    private int strikeCount;
    private int ballCount;

    public GameScore(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameScore gameScore = (GameScore) o;
        return getStrikeCount() == gameScore.getStrikeCount() && getBallCount() == gameScore.getBallCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStrikeCount(), getBallCount());
    }
}
