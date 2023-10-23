package baseball;

import static baseball.Model.MAX_STRIKES;

import baseball.entity.Ball;
import baseball.entity.GameResult;
import baseball.entity.Strike;
import baseball.enums.MessageType;
import camp.nextstep.edu.missionutils.Console;

public class View {

    public void displayScore(GameResult result) {

        Strike strike = result.getStrike();
        Ball ball = result.getBall();

        if (strike.getCount() == MAX_STRIKES) {
            displayMaxScoreMessage(strike);
            return;

        } else if (strike.getCount() == 0 && ball.getCount() == 0) {
            displayNoScoreMessage();
            return;
        }

        displayScoreMessage(strike, ball);
    }

    private void displayScoreMessage(Strike strike, Ball ball) {
        System.out.print(ball.getCount() + MessageType.BALL.getMessage() + " ");
        System.out.println(strike.getCount() + MessageType.STRIKE.getMessage());
    }

    private void displayMaxScoreMessage(Strike strike) {
        System.out.println(strike.getCount() + MessageType.STRIKE.getMessage());
    }

    private void displayNoScoreMessage() {
        displayMessage(MessageType.NOTHING);
    }

    public void displayMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    public String readInput() {
        return Console.readLine();
    }

}
