package baseball.view;

import baseball.domain.ball.BallKind;
import baseball.domain.ball.GuessResult;

public final class OutputView {

    public void printResult(final GuessResult result) {
        final String renderedResult = renderResult(result);

        System.out.println(renderedResult);
        System.out.println("게임 종료");
    }

    private String renderResult(final GuessResult result) {
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
        if (count == 0) {
            return "";
        }
        return kind.toStringWithCount(count);
    }
}
