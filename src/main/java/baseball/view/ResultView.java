package baseball.view;

public class ResultView {

    public static void printResult(final int ball, final int strike) {
        if (isBothNotZero(ball, strike)) {
            printBoth(ball, strike);
        }
    }

    private static boolean isBothNotZero(final int ball, final int strike) {
        return ball != 0 && strike != 0;
    }

    private static void printBoth(final int ball, final int strike) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}
