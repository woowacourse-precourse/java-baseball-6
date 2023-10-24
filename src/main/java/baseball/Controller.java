package baseball;

public class Controller {
    private static final String RESTART_REQUEST_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GAME_START = "1";
    private static final String PROGRAM_EXIT = "2";

    public Controller() {
    }

    private void printRestartRequestMessage() {
        System.out.println(RESTART_REQUEST_MESSAGE);
    }
}
