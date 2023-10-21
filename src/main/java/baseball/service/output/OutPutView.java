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

    private static void ballAndStrikeCheck(final Result result) {
        if (isStrike(result) && isBall(result)) {
            PrintMessage.ballAndStrikeMessage(result);
        }
    }

    private static void nothingCheck(final Result result) {
        if (!isStrike(result) && !isBall(result)) {
            PrintMessage.nothingCheckMessage(result);
        }
    }

    private static void allStrikeCheck(final Result result) {
        if (isStrike(result) && !isBall(result)) {
            PrintMessage.allStrikeResultMessage(result);
            isPlayerWin(result);
        }
    }

    private static void isPlayerWin(final Result result) {
        if (result.strikeCount() == TARGET_NUMBER) {
            PrintMessage.congratulationMessage();
        }
    }

    private static void allBallCheck(final Result result) {
        if (!isStrike(result) && isBall(result)) {
            PrintMessage.allBallResultMessage(result);
        }
    }

    private static boolean isBall(final Result result) {
        return result.ballCount() != ZERO_NUMBER;
    }

    private static boolean isStrike(final Result result) {
        return result.strikeCount() != ZERO_NUMBER;
    }
}
