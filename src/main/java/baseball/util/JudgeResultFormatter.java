package baseball.util;

import baseball.model.JudgeResult;

public class JudgeResultFormatter {
    private static final int NO_COUNT = 0;

    public static String format(JudgeResult judgeResult) {
        if (judgeResult.getNothingCount() == Constants.BALL_LENGTH) {
            return Constants.NOTHING_STRING;
        }
        StringBuilder sb = new StringBuilder();
        formatBall(judgeResult, sb);
        formatStrike(judgeResult, sb);
        return sb.toString();
    }

    private static void formatBall(JudgeResult judgeResult, StringBuilder sb) {
        if (judgeResult.getBallCount() > NO_COUNT) {
            sb.append(judgeResult.getBallCount());
            sb.append(Constants.BALL_STRING);
            sb.append(Constants.SPACE);
        }
    }

    private static void formatStrike(JudgeResult judgeResult, StringBuilder sb) {
        if (judgeResult.getStrikeCount() > NO_COUNT) {
            sb.append(judgeResult.getStrikeCount());
            sb.append(Constants.STRIKE_STRING);
        }
    }

}
