package baseball.View;

public class OutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printEnd() {
        System.out.println(END_MESSAGE);
    }

    public static void printGameResult(int strikeCount, int ballCount) {
        String result = getResultMessage(strikeCount, ballCount);
        System.out.println(result);
    }

    private static String getResultMessage(int strikeCount, int ballCount) {
        if (hasBothStrikeAndBall(strikeCount, ballCount)) {
            return ballCount + BALL + " " + strikeCount + STRIKE;
        } else if (hasStrikeOnly(strikeCount)) {
            return strikeCount + STRIKE;
        } else if (hasBallOnly(ballCount)) {
            return ballCount + BALL;
        } else {
            return NOTHING;
        }
    }

    private static boolean hasBothStrikeAndBall(int strikeCount, int ballCount) {
        return strikeCount > 0 && ballCount > 0;
    }

    private static boolean hasStrikeOnly(int strikeCount) {
        return strikeCount > 0;
    }

    private static boolean hasBallOnly(int ballCount) {
        return ballCount > 0;
    }
}
