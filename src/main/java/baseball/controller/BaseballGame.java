package baseball.controller;

import baseball.model.ComputerRandomNumbers;
import baseball.model.PlayerInputNumber;
import baseball.model.PlayerNumber;
import baseball.validator.CompareValidator;
import baseball.view.OutputView;

public class BaseballGame {
    private final ComputerRandomNumbers computer;
    private static PlayerNumber player;
    private final CompareValidator compareValidator;

    public BaseballGame() {
        computer = new ComputerRandomNumbers();
        compareValidator = new CompareValidator();
    }

    public void start() {
        do {
            getNumberFromPlayer();
            printCount(getNumberCompare());
        } while (!isGameSet());

    }

    public void getNumberFromPlayer() {
        player = new PlayerNumber(PlayerInputNumber.playerInput());
        player.getPlayerNumber();
    }

    public int[] getNumberCompare() {

        return compareValidator.getNumberCompare(player.getPlayerNumber(), computer.generate());
    }

    public void printCount(int[] count) {
        printBallCount(count);
        printStrikeCount(count);
        printNothing(count);
    }

    public static void printBallCount(int[] count) {
        if (count[0] != 0) {
            if (count[1] != 0) {
                System.out.print(count[0]);
                OutputView.printBallMessage();
            } else {
                System.out.print(count[0]);
                OutputView.printBallMessage();
            }
        }
    }

    public static void printStrikeCount(int[] count) {
        if (count[1] != 0) {
            System.out.print(count[1]);
            OutputView.printStrikeMessage();
        }
    }

    public static void printNothing(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            OutputView.printNothingMessage();
        }
    }

    public boolean isGameSet() {
        if (compareValidator.isStrike()) {
            OutputView.printGameSuccessMessage();
            return true;
        }
        return false;
    }
}
