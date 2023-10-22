package baseball.domain;

import baseball.domain.constants.ResultType;
import baseball.view.OutputView;

import static baseball.config.GlobalConfig.NUMBER_LENGTH;
import static baseball.domain.constants.ResultType.*;
import static java.lang.String.format;

public class Result {
    private final int ballCount;
    private final int strikeCount;

    private Result(final Number playerNumber, final Number computerNumber) {
        ballCount = playerNumber.countBallCount(computerNumber);
        strikeCount = playerNumber.countStrikeCount(computerNumber);
    }

    public static Result create(final Number playerNumber, final Number computerNumber) {
        return new Result(playerNumber, computerNumber);
    }

    private ResultType inspectResultType() {
        if (!hasBall() && !hasStrike()) {
            return NOTHING;
        } else if (hasBall() && hasStrike()) {
            return BALL_AND_STRIKE;
        } else if (hasBall()) {
            return ONLY_BALL;
        } else if (hasStrike()) {
            return ONLY_STRIKE;
        }
        throw new IllegalArgumentException("result type error");
    }

    private String generateResultMessage(ResultType resultType) {
        return switch (resultType) {
            case NOTHING -> resultType.getValue();
            case BALL_AND_STRIKE -> format(BALL_AND_STRIKE.getValue(), ballCount, strikeCount);
            case ONLY_BALL -> format(ONLY_BALL.getValue(), ballCount);
            case ONLY_STRIKE -> format(ONLY_STRIKE.getValue(), strikeCount);
        };
    }

    public void print() {
        ResultType resultType = inspectResultType();
        OutputView.printResult(generateResultMessage(resultType));
    }

    public boolean hasBall() {
        return ballCount > 0;
    }

    public boolean hasStrike() {
        return strikeCount > 0;
    }

    public boolean checkGameOver() {
        return strikeCount == NUMBER_LENGTH.getValue();
    }
}
