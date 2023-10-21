package baseball.util;

import baseball.domain.Judgement;
import baseball.util.enums.PitchType;

public class JudgementConverter {
    public static String of(Judgement judgement) {
        if (judgement.isNothing()) {
            return PitchType.NOTHING.getType();
        }
        if (judgement.isThreeStrike()) {
            return judgement.getStrike() + PitchType.STRIKE.getType();
        }
        return makeJudgementResult(judgement.getBall(), judgement.getStrike());
    }

    private static String makeJudgementResult(int ballCount, int strikeCount) {
        String judgementResult = "";
        if (ballCount > 0) {
            judgementResult += ballCount + PitchType.BALL.getType();
        }
        if (strikeCount > 0) {
            judgementResult += strikeCount + PitchType.STRIKE.getType();
        }
        return judgementResult;
    }

}
