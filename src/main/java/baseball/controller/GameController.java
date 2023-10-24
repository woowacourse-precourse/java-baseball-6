package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameCommand;
import baseball.model.GameStatus;
import baseball.model.Player;
import baseball.model.Result;
import baseball.model.UserComputerCompare;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private GameStatus gameStatus;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameStatus = GameStatus.GAME_START;
    }

    public void play() {
        try {
            playUntilExit();
        } catch (IllegalArgumentException exception) {
            handleException(exception);
        }
    }

    private void playUntilExit() {
        outputView.printGameStart();
        while (!GameStatus.isApplicationExit(gameStatus)) {
            Computer computer = Computer.createByNumber();
            playUntilThreeStrikes(computer);
            handleRetry();
        }
    }

    private void playUntilThreeStrikes(Computer computer) {
        while (!GameStatus.isGameOver(gameStatus)) {
            Player player = Player.createByNumber(inputView.readPlayerNumber());
            UserComputerCompare referee = UserComputerCompare.judge(computer, player);
            Result result = referee.ResultgetBallCountJudgement();
            outputView.printGameResult(result);
            gameStatus = GameStatus.fromIsThreeStrike(result.isThreeStrike());
        }
        outputView.printThreeStrike();
    }

    private void handleRetry() {
        gameStatus = GameStatus.fromSelectedRetry(isSelectedRetry());
    }

    private boolean isSelectedRetry() {
        return GameCommand.selectedRetry(inputView.readGameCommand());
    }

    private void handleException(IllegalArgumentException exception) {
        outputView.printExceptionMessage(exception);
        throw exception;
    }

}

