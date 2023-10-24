package baseball.view;

import baseball.constant.Message;
import baseball.domain.GameResult;

public class OutputView {

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public void printMessageWithoutLineChange(Message message) {
        System.out.print(message.getMessage());
    }

    public void print(String message) {
        System.out.println(message);
    }

    public void startGame() {
        printMessage(Message.START);
    }

    public void requestNumber() {
        printMessageWithoutLineChange(Message.REQUEST_NUMBER);
    }

    public void endGame() {
        printMessage(Message.END);
    }

    public void restartOrQuit() {
        printMessage(Message.RESTART_OR_QUIT);
    }

    public void result(GameResult gameResult) {
        print(gameResult.getFormattedResult());
    }
}
