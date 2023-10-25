package baseball.controller;

import baseball.domain.CompareSystem;
import baseball.domain.ComputerNumbers;
import baseball.domain.GameResult;
import baseball.domain.PlayerNumbers;
import baseball.status.RestartStatus;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final ComputerNumbers computerNumbers = new ComputerNumbers();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private GameResult gameResult;

    public void start() {
        outputView.printStartMessage();
        play();
    }

    public void play() {
        computerNumbers.selectNumbers();
        boolean isNotThreeStrike;
        do {
            outputView.printInputNumberMessage();
            isNotThreeStrike = compare(computerNumbers, inputView.readNumbers());
            outputView.printResult(gameResult);
        } while(isNotThreeStrike);
        outputView.printThreeStrike();
        restartOrExit();
    }

    public void restartOrExit() {
        if (inputView.readReplayNumber() == RestartStatus.RESTART) {
            computerNumbers.init();
            play();
            return;
        }
        outputView.printExit();
    }

    public boolean compare(ComputerNumbers computerNumbers, PlayerNumbers playerNumbers) {
        CompareSystem compareSystem = new CompareSystem(computerNumbers, playerNumbers);
        gameResult = compareSystem.compare();
        return gameResult.isNotThreeStrike();
    }
}
