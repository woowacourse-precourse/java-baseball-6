package baseball.Controller;

import baseball.Model.GenerateNumber;
import baseball.Model.PlayerNumber;
import baseball.View.InputView;
import baseball.View.OutputView;
import baseball.util.Validator;

public class BaseballGame {
    private final GenerateNumber computer;
    private static PlayerNumber player;
    private final Validator validator;

    public BaseballGame() {
        computer = new GenerateNumber();
        validator = new Validator();
    }

    public void start() {
        do {
            getNumberFromPlayer();
            printCount(getNumberCompare());
        } while (!isGameSet());
    }

    public void getNumberFromPlayer() {
        player = new PlayerNumber(InputView.setInputNumber());
        player.getPlayerNumber();
    }

    public int[] getNumberCompare() {
        return validator.getNumberCompare(player.getPlayerNumber(), computer.getComputerNumber());
    }

    public void printCount(int[] count) {
        printBallCount(count);
        printStrikeCount(count);
        printNothing(count);
    }

    public static void printBallCount(int[] count) {
        if (count[0] != 0) {
            if (count[1] != 0) {
                OutputView.printCount(count[0]);
                OutputView.printStrikeBall();
            } else {
                OutputView.printCount(count[0]);
                OutputView.printBall();
            }
        }
    }

    public static void printStrikeCount(int[] count) {
        if (count[1] != 0) {
            OutputView.printCount(count[0]);
            OutputView.printStrike();
        }
    }

    public static void printNothing(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            OutputView.printNothing();
        }
    }

    public boolean isGameSet() {
        if (validator.isThreeStrike()) {
            OutputView.printSetGameMessage();
            return true;
        }
        return false;
    }
}
