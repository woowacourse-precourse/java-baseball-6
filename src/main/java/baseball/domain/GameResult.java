package baseball.domain;

import baseball.exception.GameResultTotalCountException;

import static baseball.domain.player.Player.BASEBALL_NUMBERS_LIMIT_SIZE;

public class GameResult {
    private final int strikeCount;
    private final int ballCount;

    private GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
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
}
