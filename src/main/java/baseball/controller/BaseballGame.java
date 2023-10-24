package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private final ComputerNumber computer;
    private static PlayerNumber player;
    private final Validator validator;

    public BaseballGame() {
        computer = new ComputerNumber();
        validator = new Validator();
    }

    public void start() {
        do {
            getNumberFromPlayer();
            printCount(getNumberCompare());
        } while (!isGameSet());
    }

    private boolean isGameSet() {
        if (validator.isThreeStrike()) {
            OutputView.printGameSetMessage();
            return true;
        }
        return false;
    }

    public static void printCount(int[] count) {
        printBallCount(count);
        printStrikeCount(count);
        printNothing(count);
    }

    private static void printNothing(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            OutputView.printNothingMessage();
        }
    }

    private static void printStrikeCount(int[] count) {
        if (count[1] != 0) {
            OutputView.printCount(count[1]);
            OutputView.printStrikeMessage();
        }
    }

    private static void printBallCount(int[] count) {
        if (count[0] != 0) {
            if (count[1] != 0) {
                OutputView.printCount(count[0]);
                OutputView.printBallStrikeMessage();
            } else {
                OutputView.printCount(count[0]);
                OutputView.printBallMessage();
            }
        }
    }

    private int[] getNumberCompare() {
        return validator.getNumberCompare(player.getPlayerNumber(), computer.getComputerNumber());
    }

    private void getNumberFromPlayer() {
        player = new PlayerNumber(InputView.setUserNumber());
    }
}
