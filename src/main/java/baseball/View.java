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

        if (isMaxStrike(strike)) {
            displayStrike(strike);
            return;
        }

        if (isNoScore(ball, strike)) {
            displayMessage(MessageType.NOTHING);
            return;
        }
        displayBallAndStrike(ball, strike);
    }

    private boolean isMaxStrike(Strike strike) {
        return strike.getCount() == MAX_STRIKES;
    }

    private boolean isNoScore(Ball ball, Strike strike) {
        return ball.getCount() == 0 && strike.getCount() == 0;
    }

    private void displayBallAndStrike(Ball ball, Strike strike) {
        System.out.print(ball.getCount() + MessageType.BALL.getMessage() + " ");
        System.out.println(strike.getCount() + MessageType.STRIKE.getMessage());
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
