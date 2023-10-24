package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.player.Player;
import baseball.exception.game.GameResultTotalCountException;

import java.util.Objects;

import static baseball.domain.player.Player.BASEBALL_NUMBERS_LIMIT_SIZE;

public class GameResult {
    private final int strikeCount;
    private final int ballCount;

    private GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static GameResult init() {
        return new GameResult(0, 0);
    }

    public static GameResult from(int strikeCount, int ballCount) {
        checkStrikeAndBallTotalCount(strikeCount, ballCount);
        return new GameResult(strikeCount, ballCount);
    }

    private static void checkStrikeAndBallTotalCount(int strikeCount, int ballCount) {
        if (Math.addExact(strikeCount, ballCount) > BASEBALL_NUMBERS_LIMIT_SIZE) {
            throw new GameResultTotalCountException();
        }
    }

    public boolean isFinished() {
        return strikeCount == BASEBALL_NUMBERS_LIMIT_SIZE;
    }

    public static GameResult calculateBaseBallGame(Player player, Computer computer) {
        int strikeCount = player.calculateStrikeCounts(computer);
        int ballCount = player.calculateBallCounts(computer);
        return GameResult.from(strikeCount, ballCount);
    }

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }

    public int strikeCount() {
        return strikeCount;
    }

    public int ballCount() {
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
        GameResult that = (GameResult) o;
        return strikeCount == that.strikeCount && ballCount == that.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }
}
