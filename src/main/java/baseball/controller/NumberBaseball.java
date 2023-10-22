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
        getNumbersFromPlayer();
        getCompareResult();
    }

    public void getNumbersFromPlayer() {
        player = new Player(InputView.setGameInput());
        player.getPlayerNumbers();
    }

    public int[] getCompareResult() {
        return compareNumber.getCompareNumberResult(computer.getComputerNumbers(), player.getPlayerNumbers());
    }
}
