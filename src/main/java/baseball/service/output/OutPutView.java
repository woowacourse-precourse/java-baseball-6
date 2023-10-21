package baseball.service.output;

import baseball.dto.Result;
import baseball.util.message.PrintMessage;

public class OutPutView implements Output {
    private static final int TARGET_NUMBER = 3;
    private static final int ZERO_NUMBER = 0;

    @Override
    public void execute(final Result result) {
        ballAndStrikeCheck(result);
        allBallCheck(result);
        allStrikeCheck(result);
        nothingCheck(result);

    }

    private void ballAndStrikeCheck(final Result result) {
        if (isStrike(result) && isBall(result)) {
            PrintMessage.ballAndStrikeMessage(result);
        }
    }

    private void nothingCheck(final Result result) {
        if (!isStrike(result) && !isBall(result)) {
            PrintMessage.nothingCheckMessage(result);
        }
    }

    private void allStrikeCheck(final Result result) {
        if (isStrike(result) && !isBall(result)) {
            PrintMessage.allStrikeResultMessage(result);
            isPlayerWin(result);
        }
    }

    private void isPlayerWin(final Result result) {
        if (result.strikeCount() == TARGET_NUMBER) {
            PrintMessage.congratulationMessage();
        }
    }

    private void allBallCheck(final Result result) {
        if (!isStrike(result) && isBall(result)) {
            PrintMessage.allBallResultMessage(result);
        }
    }

    private boolean isBall(final Result result) {
        return result.ballCount() != ZERO_NUMBER;
    }

    private boolean isStrike(final Result result) {
        return result.strikeCount() != ZERO_NUMBER;
    }
}
