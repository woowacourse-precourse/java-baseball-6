package baseball.view;

import baseball.constant.Message;
import baseball.domain.GameResult;

public class OutputView {
    public void startGame() {
        System.out.println(Message.START.getMessage());
    }

    public void requestNumber() {
        System.out.print(Message.REQUEST_NUMBER.getMessage());
    }

    public void endGame() {
        System.out.println(Message.END.getMessage());
    }

    public void restartOrQuit() {
        System.out.println(Message.RESTART_OR_QUIT.getMessage());
    }

    public void invalidInputMessage(String message) {
        System.out.println(message);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void result(GameResult result) {
        int strikes = result.getStrikes();
        int balls = result.getBalls();
        StringBuilder message = new StringBuilder();

        if (strikes == 0 && balls == 0) {
            message.append(Message.NOTHING.getMessage());
        } else {
            if (balls > 0) {
                message.append(balls).append(Message.BALL.getMessage()).append(Message.BLANK.getMessage());
            }
            if (strikes > 0) {
                message.append(strikes).append(Message.STRIKE.getMessage());
            }
        }
        System.out.println(message);
    }
}
