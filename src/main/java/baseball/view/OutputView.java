package baseball.view;

public class OutputView {
    private static final int NO_COUNT = 0;
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public static void print(String string) {
        System.out.print(string);
    }

    public static void println(String string) {
        System.out.println(string);
    }

    public static void printScore(int ball, int strike) {
        if ((ball != NO_COUNT) && (strike != NO_COUNT)) {
            println(ball + BALL + " " + strike + STRIKE);
        } else if (ball != NO_COUNT) {
            println(ball + BALL);
        } else if (strike != NO_COUNT) {
            println(strike + STRIKE);
        } else if ((ball == NO_COUNT) && (strike == NO_COUNT)) {
            println(NOTHING);
        }
    }
}
