package baseball.view;

public class ResultView {

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
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    private static boolean isOnlyLeftNotZero(final int leftNumber, final int rightNumber) {
        return leftNumber != 0 && rightNumber == 0;
    }

    private static void printStrike(final int strike) {
        System.out.println(strike + "스트라이크");
    }

    private static void printBall(final int ball) {
        System.out.println(ball + "볼");
    }

    private static boolean isBothZero(final int ball, final int strike) {
        return ball == 0 && strike == 0;
    }

    private static void printNothing() {
        System.out.println("낫싱");
    }
}
