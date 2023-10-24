package baseball.game.computer;

import static baseball.game.message.ErrorMessage.INVALID_SCORE;
import static baseball.game.message.GameMessage.BALL;
import static baseball.game.message.GameMessage.NOTHING;
import static baseball.game.message.GameMessage.STRIKE;

import java.text.MessageFormat;

public class GameResult {

    private final boolean inningEnd;
    private final int ballCount;
    private final int strikeCount;

    public GameResult(final int ballCount, final int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
        validate(ballCount);
        validate(strikeCount);
        this.inningEnd = strikeCount == 3;
    }

    public boolean isInningEnd() {
        return inningEnd;
    }

    public String getGameScore() {
        final StringBuilder sb = new StringBuilder();
        if (ballCount > 0) {
            sb.append(MessageFormat.format("{0}{1} ", ballCount, BALL.getMessage()));
        }
        if (strikeCount > 0) {
            sb.append(MessageFormat.format("{0}{1}", strikeCount, STRIKE.getMessage()));
        }
        return sb.isEmpty()
                ? NOTHING.getMessage()
                : sb.toString();
    }

    private void validate(final int count) {
        if (count < 0 || count > 3) {
            throw new IllegalArgumentException(INVALID_SCORE.getMessage());
        }
    }
}
