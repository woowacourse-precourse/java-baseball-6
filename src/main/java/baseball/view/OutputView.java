package baseball.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String ONLY_BALL_MESSAGE = "%d볼";
    private static final String ONLY_STRIKE_MESSAGE = "%d스트라이크";
    private static final String BALL_AND_STRIKE_MESSAGE = "%d볼 %d스트라이크";

    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printGameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }

    public static void printNothingMessage() {
        System.out.println(NOTHING_MESSAGE);
    }

    public static void printOnlyBallMessage(int ball) {
        System.out.printf(ONLY_BALL_MESSAGE, ball);
        System.out.println();
    }

    public static void printOnlyStrikeMessage(int strike) {
        System.out.printf(ONLY_STRIKE_MESSAGE, strike);
        System.out.println();
    }

    public static void printBallAndStrikeMessage(int ball, int strike) {
        System.out.printf(BALL_AND_STRIKE_MESSAGE, ball, strike);
        System.out.println();
    }
}
