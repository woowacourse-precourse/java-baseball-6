package baseball.view;

public class OutputView {

    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료.";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";

    public static void printNothing() {
        System.out.println(NOTHING_MESSAGE);
    }

    public static void printSuccessMessage() {
        System.out.println(SUCCESS_MESSAGE);
    }

    public static void printStrike(int strike) {
        System.out.println(strike + STRIKE_MESSAGE);
    }

    public static void printBall(int ball) {
        System.out.println(ball + BALL_MESSAGE);
    }

    public static void printStrikeBall(int strike, int ball) {
        System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
    }
}
