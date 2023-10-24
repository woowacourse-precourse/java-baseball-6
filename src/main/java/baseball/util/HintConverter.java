package baseball.util;

import baseball.util.constants.PitchOutcomeConstants;

public class HintConverter {

    public static String getHint(int strike, int ball) {
        StringBuilder hintBuilder = new StringBuilder();

        if (ball > 0) {
            hintBuilder.append(ball).append(PitchOutcomeConstants.BALL).append(" ");
        }
        if (strike > 0) {
            hintBuilder.append(strike).append(PitchOutcomeConstants.STRIKE);
        }

        return hintBuilder.length() > 0 ? hintBuilder.toString() : PitchOutcomeConstants.NOTHING;
    }
}
