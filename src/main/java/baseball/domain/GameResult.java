package baseball.domain;

import baseball.config.GameConfig;
import java.util.Objects;

public class GameResult {

    private final int ballCount;
    private final int strikeCount;

    private GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public static GameResult allStrike() {
        return new GameResult(0, GameConfig.BASEBALL_LENGTH);
    }

    public static GameResult nothing() {
        return new GameResult(0, 0);
    }

    public static GameResult ballsAndStrikes(int ballCount, int strikeCount) {
        return new GameResult(ballCount, strikeCount);
    }

    public boolean isAllStrike() {
        return strikeCount == GameConfig.BASEBALL_LENGTH;
    }

    public boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameResult that = (GameResult) o;
        return ballCount == that.ballCount && strikeCount == that.strikeCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballCount, strikeCount);
    }
}
