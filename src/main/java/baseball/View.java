package baseball;

import static baseball.Model.MAX_STRIKES;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public void displayScore(GameResult result) {

        if (result.getStrike() == MAX_STRIKES) {
            System.out.println(result.getStrike() + MessageType.STRIKE.getMessage());

        } else if (result.getStrike() == 0 && result.getBall() == 0) {
            displayMessage(MessageType.NOTHING);
        } else {
            System.out.print(result.getBall() + MessageType.BALL.getMessage() + " ");
            System.out.println(result.getStrike() + MessageType.STRIKE.getMessage());
        }
    }

    public void displayMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    public String readInput() {
        return Console.readLine();
    }

}
