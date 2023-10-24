package baseball.view;

import static baseball.domain.Baseballs.BALL_SIZE;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    private static final String GAME_END_MESSAGE = BALL_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final String LINE = "\n";

    public void printStartGameMessage() {
        displayMessage(GAME_START_MESSAGE);
    }

    public void printEndGameMessage() {
        displayMessage(GAME_END_MESSAGE);
    }

    public void printResultMessage(String message) {
        displayMessage(message + LINE);
    }

    private void displayMessage(String message) {
        System.out.print(message);
    }
}
