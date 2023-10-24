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
            printBallStrikeCount(getNumberCompare());
        } while (!isGameSet());

    }

    public void getNumberFromPlayer() {
        player = new PlayerNumber(PlayerInputNumber.playerInput());
        player.getPlayerNumber();
    }

    public int[] getNumberCompare() {

        return compareValidator.getNumberCompare(computer.getComputerNumber(), player.getPlayerNumber());
    }

    public void printBallStrikeCount(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            OutputView.printNothingMessage();
        }
        if (count[0] != 0 && count[1] != 0) {
            System.out.println(count[0] + "볼 " + count[1] + "스트라이크");
        }
        if (count[0] != 0 && count[1] == 0) {
            System.out.print(count[0]);
            OutputView.printBallMessage();
        }
        if (count[0] == 0 && count[1] != 0) {
            System.out.print(count[1]);
            OutputView.printStrikeMessage();
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
