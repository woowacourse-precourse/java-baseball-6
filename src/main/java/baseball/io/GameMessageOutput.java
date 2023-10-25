package baseball.io;

public final class GameMessageOutput {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_RESTART_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String USER_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printGameRestartMessage() {
        System.out.println(GAME_RESTART_MESSAGE);
    }

    public static void printUserNumberInputMessage() {
        System.out.print(USER_NUMBER_INPUT_MESSAGE);
    }
}
