package baseball.service;

import baseball.domain.BaseBall;
import baseball.utils.HintGenerator;

import static baseball.constant.GameConstant.*;

public class PrintService {
    public String printResult(int[] answer, int[] input) {
        HintGenerator hintGenerator=new HintGenerator();
        BaseBall baseBall = hintGenerator.generateHint(answer, input);
        int size = input.length;

        if (baseBall.isNothing()) {
            return NOTHING;
        }

        if (size == baseBall.getStrike()) {
            return getGameOverMessage(size);
        }

        return generateHintMessage(baseBall, size);
    }

    private String generateHintMessage(BaseBall baseBall, int size) {
        StringBuilder result = new StringBuilder();

        appendBallHint(baseBall, result);
        appendStrikeHint(baseBall, result);

        return result.toString();
    }

    private void appendBallHint(BaseBall baseBall, StringBuilder result) {
        int ball = baseBall.getBall();
        if (ball > 0) {
            result.append(ball).append(BALL).append(" ");
        }
    }

    private void appendStrikeHint(BaseBall baseBall, StringBuilder result) {
        int strike = baseBall.getStrike();
        if (strike > 0) {
            result.append(strike).append(STRIKE);
        }
    }

    private String getGameOverMessage(int size) {
        return size + STRIKE + "\n" + GAME_OVER_PROMPT;
    }
}
