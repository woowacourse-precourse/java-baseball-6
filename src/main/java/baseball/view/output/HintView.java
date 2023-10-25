package baseball.view.output;

import static baseball.domain.ball.Hint.BALL;
import static baseball.domain.ball.Hint.NOTHING;
import static baseball.domain.ball.Hint.STRIKE;

import baseball.domain.ball.Hint;
import baseball.domain.game.GameResult;
import io.Renderable;

public final class HintView implements Renderable {
    public static final String DELIMITER = " ";
    public static final String EMPTY = "";
    public static final String LINE_BREAK = "\n";

    private final GameResult result;

    public HintView(final GameResult gameResult) {
        this.result = gameResult;
    }

    @Override
    public String render() {
        if (result.hasNothing()) {
            return NOTHING.getValue();
        }
        return String.join(DELIMITER,
                renderHint(BALL, result.ballCount()),
                renderHint(STRIKE, result.strikeCount())).trim() + LINE_BREAK;
    }

    private String renderHint(
            final Hint hint,
            final int count
    ) {
        return switch (count) {
            case 0 -> EMPTY;
            default -> count + hint.getValue();
        };
    }
}
