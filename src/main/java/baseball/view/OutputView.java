package baseball.view;

public class OutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void startGame() {
        System.out.println(START_MESSAGE);
    }

    public static void printResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        if (ball > 0 && strike > 0) {
            System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
            return;
        }
        if (ball > 0) {
            System.out.println(ball + BALL_MESSAGE);
        }
        if (strike > 0) {
            System.out.println(strike + STRIKE_MESSAGE);
        }
    }
    public static void printGameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }
}