package baseball.ui;

import static baseball.global.constant.GameMessage.GAME_FINISH_MESSAGE;
import static baseball.global.constant.GameMessage.GAME_START_MESSAGE;
import static baseball.global.constant.GameMessage.NUMBER_INPUT_MESSAGE;
import static baseball.global.constant.GameMessage.RESTART_SELECT_MESSAGE;

import baseball.domain.GameResult;

public class OutputView {

    public void printGameStartMessage() {
        println(GAME_START_MESSAGE);
    }

    public void printNumberInputMessage() {
        print(NUMBER_INPUT_MESSAGE);
    }

    public void printGameResultMessage(GameResult result) {
        println(result.toString());
    }

    public void printRestartSelectMessage() {
        println(RESTART_SELECT_MESSAGE);

    }

    public void printGameFinishMessage() {
        println(GAME_FINISH_MESSAGE);
    }

    private void println(String text) {
        System.out.println(text);
    }

    private void print(String text) {
        System.out.print(text);
    }
}
