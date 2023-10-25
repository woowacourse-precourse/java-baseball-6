package baseball.controller;

import baseball.model.computer.Computer;
import baseball.model.player.Player;
import baseball.view.CommonView;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private final Computer computer;
    private final Player player;
    private final CommonView commonView;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController(Computer computer, Player player, CommonView commonView, InputView inputView,
                                  OutputView outputView) {
        this.computer = computer;
        this.player = player;
        this.commonView = commonView;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        commonView.printStartMessage();
        while (player.continueGame()) {
            computer.makeAnswer();
            playOneRound();
            player.inputGameStateNumber();
        }
    }

    private void playOneRound() {
        computer.initScore();
        while (!computer.isScoreAllStrike()) {
            inputView.printGuessNumberInputMessage();
            player.inputGuessNumbers();
            computer.calculateScore(player.getGuessNumbers());
            outputView.printResult(computer.getScore());
        }
        inputView.printRestartOrExitInputMessage();
    }
}