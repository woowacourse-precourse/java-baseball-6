package baseball.util;

import baseball.model.JudgeResult;

public class JudgeResultFormatter {

    public static String format(JudgeResult judgeResult) {
        if (judgeResult.isNothing()) {
            return Constants.NOTHING_STRING;
        }
        StringBuilder sb = new StringBuilder();
        if (judgeResult.hasBall()) {
            sb.append(judgeResult.getBallCount());
            sb.append(Constants.BALL_STRING);
            sb.append(Constants.SPACE);
        }
        if (judgeResult.hasStrike()) {
            sb.append(judgeResult.getStrikeCount());
            sb.append(Constants.STRIKE_STRING);
        }
        return sb.toString();
    }

}
