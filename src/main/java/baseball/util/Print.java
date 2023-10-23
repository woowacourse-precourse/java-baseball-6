package baseball.util;

public class Print {
    private static final String INTRO_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String REQUIRE_USER_INPUT = "숫자를 입력해주세요: ";
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    public static void showIntro() {
        System.out.println(INTRO_MESSAGE);
    }

    public static void showPredictUserInput() {
        System.out.print(REQUIRE_USER_INPUT);
    }

    public static void showPredictResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + BALL);
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike + STRIKE);
        } else if (strike != 0 && ball != 0) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        }
    }

    public static void showGameOver() {
        System.out.println(GAME_OVER);
    }

    public static void showRestartOrExitInput() {
        System.out.println(RESTART_OR_EXIT);
    }
}
