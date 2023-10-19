package baseball.view;

public class OutputView {

    private static final String BASEBALL_GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String BASEBALL_GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    public OutputView() {
    }

    public static void printStartMessage() {
        System.out.println(BASEBALL_GAME_START_MESSAGE);
    }

    public static void printClearMessage() {
        System.out.println(BASEBALL_GAME_CLEAR_MESSAGE);
    }

    public static void printGameResult() {
        printGameResultAllStrike();
        printGameResultAllBall();
        printGameResultBallAndStrike();
        printGameResultNothing();
    }

    private static void printGameResultAllStrike() {

    }

    private static void printGameResultAllBall() {

    }

    private static void printGameResultBallAndStrike() {

    }

    private static void printGameResultNothing() {

    }
}
