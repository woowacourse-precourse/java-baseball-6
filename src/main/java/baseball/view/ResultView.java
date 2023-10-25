package baseball.view;

public class ResultView {

    private static final String GAME_END_MESSAGE = "게임 종료";
    private static final String ALL_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STATE_FORMAT = "%d%s";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final Integer ZERO_COUNT = 0;

    public static void printResult(int ballCount, int strikeCount) {
        printBall(ballCount);
        printStrike(strikeCount);
        printNothing(ballCount, strikeCount);
        System.out.println();
    }


    private static void printNothing(int ballCount, int strikeCount) {
        if (ballCount == ZERO_COUNT && strikeCount == ZERO_COUNT) {
            System.out.print(NOTHING);
        }
    }

    private static void printStrike(int strikeCount) {
        if (strikeCount != ZERO_COUNT) {
            System.out.printf(STATE_FORMAT, strikeCount, STRIKE);
        }
    }

    private static void printBall(int ballCount) {
        if (ballCount != ZERO_COUNT) {
            System.out.printf(STATE_FORMAT, ballCount, BALL);
        }
    }

    public static void printResultInfoMessage() {
        System.out.println(ALL_CLEAR_MESSAGE);
    }

    public static void printGameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }
}
