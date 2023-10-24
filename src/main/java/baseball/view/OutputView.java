package baseball.view;

import baseball.domain.ball.BallKind;
import baseball.domain.game.GameResult;

public final class OutputView {

    public void printResult(final GameResult result) {
        System.out.println(renderResult(result));
    }

    private String renderResult(final GameResult result) {
        if (result.hasNothing()) {
            return "낫싱";
        }
        return renderCountOf(BallKind.BALL, result.ballCount()) +
                renderCountOf(BallKind.STRIKE, result.strikeCount());
    }

    private String renderCountOf(
            final BallKind kind,
            final int count
    ) {
        return switch (count) {
            case 0 -> "";
            default -> kind.toStringWithCount(count);
        };
    }
}
