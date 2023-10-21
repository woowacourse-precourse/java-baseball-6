package baseball;

public class OutputView {

    private static final int BASEBALL_NUMBERS_LENGTH = 3;
    private static final String GAME_RESTART = "1";
    private static final String GAME_OVER = "2";
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String ANSWER_MESSAGE = BASEBALL_NUMBERS_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_MESSAGE =
            "게임을 새로 시작하려면 " + GAME_RESTART + ", 종료하려면" + GAME_OVER + "를 입력하세요.";

    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printEnterNumber() {
        System.out.println(ENTER_NUMBER_MESSAGE);
    }

    public static void printBallStrikeCount(int ballCount, int strikeCount) {
        printBallCount(ballCount);
        printStrikeCount(strikeCount);
        printNothing(ballCount, strikeCount);
        System.out.println();
    }

    public static void printBallCount(int ballCount) {
        if (ballCount != 0) {
            System.out.print(ballCount + BALL);
        }
    }

    public static void printStrikeCount(int strikeCount) {
        if (strikeCount != 0) {
            System.out.print(strikeCount + STRIKE);
        }
    }

    public static void printNothing(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print(NOTHING);
        }
    }

    public static void printAnswer() {
        System.out.println(ANSWER_MESSAGE);
        System.out.println(GAME_RESTART_MESSAGE);
    }
}
