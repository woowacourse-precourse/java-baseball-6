package baseball.util;

import baseball.model.JudgeResult;

public class JudgeResultFormatter {
    private static final int NO_COUNT = 0;
    private static final String NOTHING_STRING = "낫싱";
    private static final String BALL_STRING = "볼";
    private static final String STRIKE_STRING = "스트라이크";
    private static final String SPACE = " ";

    public static String format(JudgeResult judgeResult) {
        if (judgeResult.getNothingCount() == Constants.BALL_LENGTH) {
            return NOTHING_STRING;
        }
        StringBuilder sb = new StringBuilder();
        formatBall(judgeResult, sb);
        formatStrike(judgeResult, sb);
        return sb.toString();
    }

    private static void formatBall(JudgeResult judgeResult, StringBuilder sb) {
        if (judgeResult.getBallCount() > NO_COUNT) {
            sb.append(judgeResult.getBallCount());
            sb.append(BALL_STRING);
            sb.append(SPACE);
        }
    }

    private static void formatStrike(JudgeResult judgeResult, StringBuilder sb) {
        if (judgeResult.getStrikeCount() > NO_COUNT) {
            sb.append(judgeResult.getStrikeCount());
            sb.append(STRIKE_STRING);
        }
    }

}
