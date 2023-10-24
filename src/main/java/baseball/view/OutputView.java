package baseball.view;

import baseball.model.dto.PrintMessage;
import baseball.model.dto.Score;

public class OutputView {
    public void printResult(Score score) {
        printMessage(score);
    }

    public void printInputNumberMessage() {
        printMessage(PrintMessage.INPUT_NUMBER_MESSAGE.toString());
    }

    public void printGameRestartMessage() {
        printMessage(PrintMessage.INPUT_RESTART_NUMBER_MESSAGE.toString());
    }

    public void printGameStart() {
        printMessage(PrintMessage.GAME_START_MESSAGE.toString());
    }

    public void printGameEnd() {
        printMessage(PrintMessage.GAME_END_MESSAGE.toString());
    }

    private void printMessage(Score score) {
        System.out.print(score);
    }

    private void printMessage(String message) {
        System.out.print(message);
    }
}
