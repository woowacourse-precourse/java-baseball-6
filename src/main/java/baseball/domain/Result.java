package baseball.domain;

import baseball.domain.constants.ResultType;
import baseball.global.exception.BaseballException;

import static baseball.domain.constants.ResultType.*;
import static baseball.global.GameConfig.NUMBER_LENGTH;
import static baseball.global.exception.ErrorMessage.SYSTEM_ERROR;
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
        if (isNothing()) {
            return NOTHING;
        }
        if (hasBallAndStrike()) {
            return BALL_AND_STRIKE;
        }
        if (hasBall()) {
            return ONLY_BALL;
        }
        if (hasStrike()) {
            return ONLY_STRIKE;
        }
        throw BaseballException.of(SYSTEM_ERROR);
    }

    private boolean hasBallAndStrike() {
        return hasBall() && hasStrike();
    }

    private boolean isNothing() {
        return !hasBall() && !hasStrike();
    }

    private String generateResultMessage(ResultType resultType) {
        return switch (resultType) {
            case NOTHING -> resultType.getValue();
            case BALL_AND_STRIKE -> format(BALL_AND_STRIKE.getValue(), ballCount, strikeCount);
            case ONLY_BALL -> format(ONLY_BALL.getValue(), ballCount);
            case ONLY_STRIKE -> format(ONLY_STRIKE.getValue(), strikeCount);
        };
    }

    public String createResultMessage() {
        ResultType resultType = inspectResultType();
        return generateResultMessage(resultType);
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
