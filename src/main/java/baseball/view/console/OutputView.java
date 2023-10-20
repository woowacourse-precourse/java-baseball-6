package baseball.view.console;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    private static final String INPUT_BALLS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final String INPUT_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public void gameStartMessage() {
        displayMessage(GAME_START_MESSAGE);
    }

    public void inputBallsMessage() {
        displayMessage(INPUT_BALLS_MESSAGE);
    }

    public void gameEndMessage() {
        displayMessage(GAME_END_MESSAGE);
    }

    public void inputGameRestartMessage() {
        displayMessage(INPUT_GAME_RESTART_MESSAGE);
    }

    public void resultMessage(String message) {
        displayMessage(message + "\n");
    }


    private void displayMessage(String message) {
        System.out.print(message);
    }
}
