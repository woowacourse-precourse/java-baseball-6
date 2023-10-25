package baseball.view;

public class OutPutView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_SET_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOTHING_MATCH = "낫싱";
    private static final String ONLY_BALL = "볼";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";

    public static void displayGameStartMessage() {
        printlnMessage(GAME_START_MESSAGE);
    }

    public static void displayInputNumberMessage() {
        printMessage(INPUT_NUMBER_MESSAGE);
    }

    public static void displayRestartOrExitMessage() {
        printlnMessage(RESTART_OR_END_MESSAGE);
    }

    public static void displayGameSetMessage() {
        printlnMessage(GAME_SET_MESSAGE);
    }

    public static void displayNothingMatch(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            printlnMessage(NOTHING_MATCH);
        }
    }

    public static void displayBall(int strike, int ball) {
        if (strike == 0 && ball != 0) {
            printlnMessage(ball + ONLY_BALL);
        }
        if (strike != 0 && ball != 0) {
            printMessage(ball + BALL);
        }
    }

    public static void displayStrike(int strike) {
        if (strike != 0) {
            printlnMessage(strike + STRIKE);
        }
    }

    private static void printMessage(String message) {
        System.out.print(message);
    }

    private static void printlnMessage(String message) {
        System.out.println(message);
    }
}
