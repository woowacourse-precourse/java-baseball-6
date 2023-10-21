package baseball;

public class Printer {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_WIN_MESSAGE = Constants.GAME_WIN + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_OR_QUIT_MESSAGE = "게임을 새로 시작하려면 "
            + Constants.GAME_RESTART + ", 종료하려면 " + Constants.GAME_QUIT + "를 입력하세요.";

    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public static void printHint(Hint hint) {
        System.out.println(hint.getHint());
    }

    public static void printGameWin() {
        System.out.println(GAME_WIN_MESSAGE);
    }

    public static void printGameRestartOrQuit() {
        System.out.println(GAME_RESTART_OR_QUIT_MESSAGE);
    }
}
