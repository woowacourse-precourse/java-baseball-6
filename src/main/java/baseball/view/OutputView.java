package baseball.view;

public class OutputView {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printGameStart() {
        System.out.println(GAME_START);
    }

    public static void printGameOver() {
        System.out.println(GAME_OVER);
    }

    public static void printHint(String hint) {
        System.out.println(hint);
    }
}
