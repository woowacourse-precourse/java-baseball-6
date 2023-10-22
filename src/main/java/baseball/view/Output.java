package baseball.view;

public class Output {
    private static final String INITIAL_GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printInitialGameStartMessage() {
        System.out.println(INITIAL_GAME_START_MESSAGE);
    }

    public static void printRestartGameMessage() {
        System.out.println(RESTART_GAME_MESSAGE);
    }

    public static void printNumberInputMessage() {
        System.out.print(NUMBER_INPUT_MESSAGE);
    }

    public static void printGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

    public static void printHint(String hint) {
        System.out.println(hint);
    }
}

