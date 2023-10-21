package baseball.controller;

import baseball.model.domain.Computer;
import baseball.model.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseball {
    private final Computer computer;
    private Player player;

    public NumberBaseball() {
        computer = new Computer();
    }

    public void start() {
        OutputView.printGameStart();
        getNumbersFromPlayer();
    }

    public void getNumbersFromPlayer() {
        player = new Player(InputView.setGameInput());
        player.getPlayerNumbers();
    }
}
