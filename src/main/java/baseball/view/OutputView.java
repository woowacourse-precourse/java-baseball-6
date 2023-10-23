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

    public void result(GameResult result) {
        int strikes = result.getStrikes();
        int balls = result.getBalls();
        StringBuilder output = new StringBuilder();

        if (strikes == 0 && balls == 0) {
            output.append(Message.NOTHING.getMessage());
        } else {
            if (balls > 0) {
                output.append(Message.BALL.format(balls));
            }
            if (strikes > 0) {
                output.append(Message.STRIKE.format(strikes));
            }
        }
        print(output.toString());
    }
}
