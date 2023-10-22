package baseball.view;

public class OutputView {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String ASK_PLAYER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String ASK_RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOTHING = "낫싱";
    private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printAskNumber() {
        System.out.print(ASK_PLAYER_NUMBER);
    }

    public static void printInitialGameStart() {
        System.out.println(GAME_START);
    }

    public static void printAskRestartOrExit() {
        System.out.println(ASK_RESTART_OR_EXIT);
    }

    public static void printNothing() {
        System.out.println(NOTHING);
    }

    public static void printGameOver() {
        System.out.println(GAME_OVER);
    }

    public static void printBallCount(int ballCount) {
        String result = String.format("%d볼", ballCount);
        System.out.println(result);
    }

    public static void printStrikeCount(int strikeCount) {
        String result = String.format("%d스트라이크", strikeCount);
        System.out.println(result);
    }

    public static void printBallAndStrikeCount(int ballCount, int strikeCount) {
        String result = String.format("%d볼 %d스트라이크", ballCount, strikeCount);
        System.out.println(result);
    }
}
