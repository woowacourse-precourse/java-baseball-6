package baseball.service;

import static baseball.domain.Constants.BALL;
import static baseball.domain.Constants.NOTHING;
import static baseball.domain.Constants.NUMBER_OF_BASEBALL;
import static baseball.domain.Constants.STRIKE;

import baseball.domain.BaseballNumbers;

public class HintService {
    public String createHintMessage(BaseballNumbers computerNumber, BaseballNumbers inputNumber) {
        if (computerNumber.isNothing(inputNumber)) {
            return NOTHING;
        }

        int ballCount = computerNumber.getBallCount(inputNumber);
        int strikeCount = computerNumber.getStrikeCount(inputNumber);
        StringBuilder hintMsg = createBallAndStrikeHint(ballCount, strikeCount);

        return hintMsg.toString();
    }

    public StringBuilder createBallAndStrikeHint(int ballCount, int strikeCount) {
        StringBuilder hintMsg = new StringBuilder();

        appendBallCount(hintMsg, ballCount);
        if (ballCount > 0 && strikeCount > 0) {
            hintMsg.append(" ");
        }
        appendStrikeCount(hintMsg, strikeCount);

        return hintMsg;
    }

    public void appendBallCount(StringBuilder hintMsg, int ballCount) {
        if (ballCount > 0) {
            hintMsg.append(ballCount).append(BALL);
        }
    }

    public void appendStrikeCount(StringBuilder hintMsg, int strikeCount) {
        if (strikeCount > 0) {
            hintMsg.append(strikeCount).append(STRIKE);
        }
    }

    public boolean isCorrect(BaseballNumbers computerNumber, BaseballNumbers inputNumber) {
        int strikeCount = computerNumber.getStrikeCount(inputNumber);

        if (strikeCount == NUMBER_OF_BASEBALL) {
            return true;
        }

        return false;
    }
}
