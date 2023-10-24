package baseball.view.output;

import baseball.domain.game.GameResult;
import io.Renderable;

public final class HintView implements Renderable {
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";

    private final GameResult result;

    public HintView(final GameResult gameResult) {
        this.result = gameResult;
    }

    @Override
    public String renderToString() {
        if (result.hasNothing()) {
            return NOTHING;
        }
        return String.join(" ",
                renderHint(BALL, result.ballCount()),
                renderHint(STRIKE, result.strikeCount())).trim() + "\n";
    }

    private String renderHint(
            final String hint,
            final int count
    ) {
        return switch (count) {
            case 0 -> "";
            default -> count + hint;
        };
    }
}
