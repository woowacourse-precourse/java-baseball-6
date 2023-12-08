package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGame {

    private final OutputView outputView;
    private final InputView inputView;
    private final Computer computer;
    private final Player player;

    public BaseballGame(OutputView outputView, InputView inputView, Computer computer, Player player) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.computer = computer;
        this.player = player;
    }

    public void start() {
        outputView.printStartMessage();

        do {
            play();
        } while (isContinue());
    }

    private void play() {
        computer.generateNumbers();

        List<Integer> inputNumbers = inputView.enterUserNumbers();
        player.chooseNumbers(inputNumbers);
    }

    private boolean isContinue() {
        return false;
    }
}
