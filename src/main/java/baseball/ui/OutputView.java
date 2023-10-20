package baseball.ui;

import static baseball.global.constant.GameMessage.GAME_FINISH_MESSAGE;
import static baseball.global.constant.GameMessage.GAME_START_MESSAGE;
import static baseball.global.constant.GameMessage.NUMBER_INPUT_MESSAGE;
import static baseball.global.constant.GameMessage.RESTART_SELECT_MESSAGE;

import baseball.domain.GameResult;

public class OutputView {

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printNumberInputMessage() {
        System.out.print(NUMBER_INPUT_MESSAGE);
    }

    public void printGameResultMessage(GameResult result) {
        System.out.println(result.toString());
    }

    public void printRestartSelectMessage() {
        System.out.println(RESTART_SELECT_MESSAGE);

    }

    public void printGameFinishMessage() {
        System.out.println(GAME_FINISH_MESSAGE);
    }


}
