package baseball.util;

import baseball.domain.Judgement;
import baseball.util.enums.PitchType;

public class JudgementConverter {
    public static String of(Judgement judgement) {
        if (judgement.isNothing()) {
            return PitchType.NOTHING.getValue();
        }
        if (judgement.isThreeStrike()) {
            return judgement.getStrike() + PitchType.STRIKE.getValue();
        }
        return makeScoreResult(judgement.getBall(), judgement.getStrike());
    }

    private static String makeScoreResult(int ballCount, int strikeCount) {
        StringBuilder resultBuilder = new StringBuilder();
        if (ballCount > 0) {
            resultBuilder.append(ballCount).append(PitchType.BALL.getValue());
        }
        if (strikeCount > 0) {
            resultBuilder.append(strikeCount).append(PitchType.STRIKE.getValue());
        }
        return resultBuilder.toString();
    }

}
