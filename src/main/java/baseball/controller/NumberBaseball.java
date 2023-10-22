package baseball.controller;

import baseball.model.domain.Computer;
import baseball.model.domain.Player;
import baseball.utils.CompareNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseball {
    private final Computer computer;
    private final CompareNumber compareNumber;
    private Player player;

    public NumberBaseball() {
        computer = new Computer();
        compareNumber = new CompareNumber();
    }

    public void start() {
        OutputView.printGameStart();
        do {
            getNumbersFromPlayer();
            printHint(getCompareResult());
        } while (isContinue());
    }

    public void getNumbersFromPlayer() {
        player = new Player(InputView.setGameInput());
        player.getPlayerNumbers();
    }

    public int[] getCompareResult() {
        return compareNumber.getCompareNumberResult(computer.getComputerNumbers(), player.getPlayerNumbers());
    }

    public void printHint(int[] count) {
        printBallCount(count);
        printStrikeCount(count);
        printNothing(count);
    }

    public void printBallCount(int[] count) {
        if (count[0] != 0) {
            if (count[1] != 0) {
                OutputView.printCount(count[0]);
                OutputView.printBallStrike();
            } else if (count[1] == 0) {
                OutputView.printCount(count[0]);
                OutputView.printBall();
            }
        }
    }

    public void printStrikeCount(int[] count) {
        if (count[1] != 0) {
            OutputView.printCount(count[1]);
            OutputView.printStrike();
        }
    }

    public void printNothing(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            OutputView.printNothing();
        }
    }

    public boolean isContinue() {
        if (compareNumber.isCorrect()) {
            OutputView.printGameClear();
            return false;
        }
        return true;
    }
}
