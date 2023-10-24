package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.utils.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private final ComputerNumber computer;
    private static PlayerNumber player;
    private final Referee referee;

    public BaseballGame() {
        computer = new ComputerNumber();
        referee = new Referee();
    }

    public void start() {
        do {
            getNumberFromPlayer();
            printCount(getNumberCompare());
        } while (!isGameSet());
    }

    public void getNumberFromPlayer() {
        player = new PlayerNumber(InputView.setUserNumber());
        player.getPlayerNumberList();
    }

    public int[] getNumberCompare() {
        return referee.getNumberCompare(player.getPlayerNumberList(), computer.getComputerNumberList());
    }

    public void printCount(int[] count) {
        printBallCount(count);
        printStrikeCount(count);
        printNothing(count);
        OutputView.printEndLine();
    }

    public static void printBallCount(int[] count) {
        if (count[0] != 0) {
            OutputView.printCount(count[0]);
            OutputView.printBallMessage();
            if (count[1] != 0) {
                OutputView.printSpace();
            }
        }
    }

    public static void printStrikeCount(int[] count) {
        if (count[1] != 0) {
            OutputView.printCount(count[1]);
            OutputView.printStrikeMessage();
        }
    }

    public static void printNothing(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            OutputView.printStrikeMessage();
        }
    }

    public boolean isGameSet() {
        if (referee.isThreeStrike()) {
            OutputView.printGameSetMessage();
            return true;
        }
        return false;
    }


}
