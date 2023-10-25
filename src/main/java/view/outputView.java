package view;

public class outputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final int ZERO = 0;
    private static final String RESULT_FORMAT = "%d%s ";

    // printGameStartMessage: 게임 시작 메시지 출력
    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printResult(int ballCnt, int strikeCnt) {
        printBall(ballCnt);
        printStrike(strikeCnt);
        printNothing(ballCnt, strikeCnt);
        System.out.println();
    }

    private static void printBall(int ballCnt) {
        if (ballCnt != ZERO) {
            System.out.printf(RESULT_FORMAT, ballCnt, BALL);
        }
    }

    private static void printStrike(int strikeCnt) {
        if (strikeCnt != ZERO) {
            System.out.printf(RESULT_FORMAT, strikeCnt, STRIKE);
        }
    }

    private static void printNothing(int ballCnt, int strikeCnt) {
        if (ballCnt == 0 && strikeCnt == 0) {
            System.out.print(NOTHING);
        }
    }

    public static void printThreeStrikeMessage() {
        System.out.println(THREE_STRIKE_MESSAGE);
    }

    public static void printGameEndMessage() {
    }
}
