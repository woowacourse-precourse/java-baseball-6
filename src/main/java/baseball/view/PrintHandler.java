package baseball.view;

import baseball.domain.BallCount;

import static baseball.view.Printer.*;

public class PrintHandler {

    public static void printResultOfGame(BallCount result) {
        if (result.getBall() == 0) {
            printWithoutBall(result.getStrike());
            return;
        }

        if (result.getStrike() == 0) {
            printBallMessageWithoutStrike(result.getBall());
            return;
        }

        printBallMessageWithStrike(result.getBall());
        printStrikeMessage(result.getStrike());
    }

    private static void printWithoutBall(int countOfStrike) {
        if (countOfStrike == 0) {
            printNothingMessage();
            return;
        }

        printStrikeMessage(countOfStrike);
    }

}
