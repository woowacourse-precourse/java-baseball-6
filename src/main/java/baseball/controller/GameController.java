package baseball.controller;

import baseball.constant.RetryCommand;
import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        outputView.printStartMessage();
        while (true) {
            Computer computer = new Computer();
            playUntilThreeStrike(computer);
            RetryCommand retryCommand = readRetry();
            if (retryCommand.isEnd()) {
                break;
            }
        }
    }

    private void playUntilThreeStrike(Computer computer) {
        while (true) {
            Player player = readPlayerBall();
            GameResult result = computer.calculateBallCount(player);
            outputView.printGameResult(result);
            if (result.isThreeStrike()) {
                break;
            }
        }
    }

    private RetryCommand readRetry() {
        outputView.printGameEnd();
        return inputView.readRetry();
    }
    private Player readPlayerBall() {
        outputView.printInputGuide();
        return new Player(inputView.readPlayerBall());
    }
}