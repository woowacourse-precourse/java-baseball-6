package baseball.view;

import static baseball.model.BaseballModel.MAX_SCORE;

import baseball.entity.Ball;
import baseball.entity.GameResult;
import baseball.entity.Strike;
import baseball.enums.MessageType;
import camp.nextstep.edu.missionutils.Console;

public class BaseballView {

    public void displayScore(GameResult result) {
        Strike strike = result.getStrike();
        Ball ball = result.getBall();

        if (isMaxStrike(strike)) {
            displayStrike(strike);
            return;
        }

        if (isMaxBall(ball)) {
            displayBall(ball);
            return;
        }

        if (isNoScore(ball, strike)) {
            displayMessage(MessageType.NOTHING);
            return;
        }

        displayBallAndStrike(ball, strike);
    }

    private boolean isMaxStrike(Strike strike) {
        return strike.getCount() == MAX_SCORE;
    }

    private boolean isMaxBall(Ball ball) {
        return ball.getCount() == MAX_SCORE;
    }

    private boolean isNoScore(Ball ball, Strike strike) {
        return ball.getCount() == 0 && strike.getCount() == 0;
    }

    private void displayBallAndStrike(Ball ball, Strike strike) {
        System.out.print(ball.getCount() + MessageType.BALL.getMessage() + " ");
        System.out.println(strike.getCount() + MessageType.STRIKE.getMessage());
    }

    private void displayBall(Ball ball) {
        System.out.println(ball.getCount() + MessageType.BALL.getMessage());
    }

    private void displayStrike(Strike strike) {
        System.out.println(strike.getCount() + MessageType.STRIKE.getMessage());
    }

    public void displayMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    public String readInput() {
        return Console.readLine();
    }
}
