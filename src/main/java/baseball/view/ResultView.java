package baseball.view;

public class ResultView {

    private static final String BALL_MARK = "볼";
    private static final String STRIKE_MARK = "스트라이크";
    private static final String NOTHING_MARK = "낫싱";

    public static void printResult(final int ball, final int strike) {
        if (isBothNotZero(ball, strike)) {
            printBoth(ball, strike);
        }
        if (isOnlyLeftNotZero(strike, ball)) {
            printStrike(strike);
        }
        if (isOnlyLeftNotZero(ball, strike)) {
            printBall(ball);
        }
        if (isBothZero(ball, strike)) {
            printNothing();
        }
    }

    private static boolean isBothNotZero(final int ball, final int strike) {
        return ball != 0 && strike != 0;
    }

    private static void printBoth(final int ball, final int strike) {
        System.out.println(ball + BALL_MARK + " " + strike + STRIKE_MARK);
    }

    private static boolean isOnlyLeftNotZero(final int leftNumber, final int rightNumber) {
        return leftNumber != 0 && rightNumber == 0;
    }

    private static void printStrike(final int strike) {
        System.out.println(strike + STRIKE_MARK);
    }

    private static void printBall(final int ball) {
        System.out.println(ball + BALL_MARK);
    }

    private static boolean isBothZero(final int ball, final int strike) {
        return ball == 0 && strike == 0;
    }

    private static void printNothing() {
        System.out.println(NOTHING_MARK);
    }
}
