package baseball.view;

import baseball.model.dto.PrintMessage;
import baseball.model.dto.Score;

public class OutView {
    public void printResult(Score score) {
        printMessage(score);
    }
    public void printInputNumberMessage() {
        printMessage(PrintMessage.INPUT_NUMBER_MESSAGE.toString());
    }
    public void printGameRestartMessage() {
        printMessage(PrintMessage.INPUT_RESTART_NUMBER_MESSAGE.toString());
    }

    public void printGameEnd() {
        printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }
    private void printMessage(Score score) {
        System.out.print(score);
    }
    private void printMessage(String message) {
        System.out.print(message);
    }
}
