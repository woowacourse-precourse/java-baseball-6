package baseball.controller;

import baseball.domain.player.Computer;
import baseball.domain.player.Player;
import baseball.domain.result.GameResult;
import baseball.domain.trigger.RetryTrigger;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private Computer computer;

    public void game() {
        OutputView.printStartMessage();
        do {
            playGame();
        } while (retryGame());
    }

    private void playGame() {
        computer = new Computer();
        while (!gameOnGoing()) ;
        OutputView.printEndMessage();
    }

    private boolean gameOnGoing() {
        Player player = new Player(InputView.inputNumber());
        GameResult gameResult = computer.compareWithPlayer(player);
        OutputView.printGameResult(gameResult);
        return gameResult.isGameEnd();
    }

    private boolean retryGame() {
        return new RetryTrigger(InputView.inputRetryGame()).retryOrNot();
    }
}