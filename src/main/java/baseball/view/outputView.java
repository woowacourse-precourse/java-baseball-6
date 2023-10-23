package baseball.view;

public class outputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_GAME_RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void displayNewGameMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void displayExitMessage() {
        System.out.println(GAME_CLEAR_MESSAGE);
    }

    public static void displayAskRestartOrExitGame() {
        System.out.println(ASK_GAME_RESTART_OR_EXIT_MESSAGE);
    }

    public static void displayGetPlayResult(int strikes, int balls) {
        if (strikes > 0 && balls > 0) {
            System.out.println(balls + BALL_MESSAGE + " " + strikes + STRIKE_MESSAGE);
        } else if (strikes > 0) {
            System.out.println(strikes + STRIKE_MESSAGE);
        } else if (balls > 0) {
            System.out.println(balls + BALL_MESSAGE);
        } else {
            System.out.println(NOTHING_MESSAGE);
        }
    }
}
