package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.GameSettings;
import baseball.model.UserNumber;
import baseball.view.Input;
import baseball.view.Output;

public class BaseBall {

    private static final int NUMBER_LENGTH = 3;
    public static String restart = "1";
    public static ComputerNumber computerNumber;

    public void gameStart() {

        do {
            Output.startMessage();
            computerNumber = new ComputerNumber();
            compareNumbers();
            Output.completeMessage();
            restart = CheckInput.checkRestart(Input.getRestartInput());
        } while (restart.equals("1"));

    }

    public static void compareNumbers() {
        do {
            GameSettings.initialize();
            UserNumber userNumber = Output.requestInputMessage();
            countStrikesAndBalls(computerNumber, userNumber);
            Output.hintMessage();
        } while (GameSettings.strike != 3);
    }

    public static void countStrikesAndBalls(ComputerNumber computerNumber, UserNumber userNumber) {
        countStrike(computerNumber, userNumber);
        countBall(computerNumber, userNumber);
    }

    public static void countStrike(ComputerNumber computerNumber, UserNumber userNumber) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (doesContain(computerNumber, userNumber, i) && isSamePosition(computerNumber, userNumber, i)) {
                GameSettings.strike++;
            }
        }
    }

    public static void countBall(ComputerNumber computerNumber, UserNumber userNumber) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (doesContain(computerNumber, userNumber, i) && !isSamePosition(computerNumber, userNumber, i)) {
                GameSettings.ball++;
            }

        }
    }

    public static boolean doesContain(ComputerNumber computerNumber, UserNumber userNumber, int position) {
        return computerNumber.contains(userNumber.get(position));
    }

    public static boolean isSamePosition(ComputerNumber computerNumber, UserNumber userNumber, int position) {
        return computerNumber.indexOf(userNumber.get(position)) == position;
    }

}
