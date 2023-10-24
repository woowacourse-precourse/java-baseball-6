package baseball.view;

import baseball.model.BallCount;
import baseball.model.Result;

public class OutputView {
    public void printGameResult(Result result) {
        int strikeCount = result.getResultByBallCount(BallCount.STRIKE);
        int ballCount = result.getResultByBallCount(BallCount.BALL);

        String gameResultMessage = buildGameResultMessage(strikeCount, ballCount);
        System.out.println(gameResultMessage);
    }

    private String buildGameResultMessage(int strikeCount, int ballCount) {
        if (isNothing(strikeCount, ballCount)) {
            return BallCount.NOTHING.getBaseballjudgment();
        }

        return formatGameResultMessage(strikeCount, ballCount);
    }

    private boolean isNothing(int strikeCount, int ballCount) {
        return strikeCount == 0 && ballCount == 0;
    }

    private String formatGameResultMessage(int strikeCount, int ballCount) {
        StringBuilder gameResult = new StringBuilder();

        if (ballCount > 0) {
            gameResult.append(String.format("%d %s ", ballCount, BallCount.BALL.getBaseballjudgment()));
        }
        if (strikeCount > 0) {
            gameResult.append(String.format("%d %s", strikeCount, BallCount.STRIKE.getBaseballjudgment()));
        }

        return gameResult.toString().trim(); // removes any extra spaces
    }

}
