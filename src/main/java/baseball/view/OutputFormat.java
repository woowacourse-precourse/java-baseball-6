package baseball.view;

public class OutputFormat {

    private static final int OUT_CRITERION = 3;
    private static final int ZERO = 0;

    public static String getFormat(int strikeCount, int ballCount, int outCount) {
        if (isBallAndStrike(strikeCount, ballCount)) {
            return String.format("%d볼 %d스트라이크", ballCount, strikeCount);
        }
        if (isStrikeOnly(strikeCount, ballCount)) {
            return String.format("%d스트라이크", strikeCount);
        }
        if (isBallOnly(strikeCount, ballCount)) {
            return String.format("%d볼", ballCount);
        }
        if (isThreeOut(outCount)) {
            return "낫싱";
        }
        return null;
    }

    private static boolean isThreeOut(int outCount) {
        return outCount == OUT_CRITERION;
    }

    private static boolean isBallOnly(int strikeCount, int ballCount) {
        return strikeCount == ZERO && ballCount > ZERO;
    }

    private static boolean isStrikeOnly(int strikeCount, int ballCount) {
        return strikeCount > ZERO && ballCount == ZERO;
    }

    private static boolean isBallAndStrike(int strikeCount, int ballCount) {
        return strikeCount > ZERO && ballCount > ZERO;
    }
}