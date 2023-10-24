package baseball.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAMEOVER_MESSAGE = "게임 종료";
    private static final String RESATRT_OR_GAMEOVER_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void gameStartPrint() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void playerInputPrint() {
        System.out.println(INPUT_MESSAGE);
    }

    public static void correctInputPrint() {
        System.out.println(CORRECT_MESSAGE);
    }

    public static void gameOverPrint() {
        System.out.println(GAMEOVER_MESSAGE);
    }

    public static void restartAndGameOverPrint() {
        System.out.println(RESATRT_OR_GAMEOVER_MESSAGE);
    }

    public static void gameResultPrint(String result) {
        System.out.println(result);
    }
}
