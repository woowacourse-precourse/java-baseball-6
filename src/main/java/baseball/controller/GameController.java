package baseball.controller;

import baseball.constant.RetryCommand;
import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.domain.BaseBallGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private BaseBallGame baseBallGame;

    public void start() {
        outputView.printStartMessage();
        playGame();
    }

    public void playGame() {
        while (true) {
            baseBallGame = new BaseBallGame(new Computer());
            playUntilThreeStrike();
            RetryCommand retryCommand = readRetry();
            if (retryCommand.isEnd()) {
                break;
            }
        }
    }

    private void playUntilThreeStrike() {
        while (baseBallGame.isProgress()) {
            GameResult result = baseBallGame.getBallCount(readPlayerBall());
            outputView.printGameResult(result);
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