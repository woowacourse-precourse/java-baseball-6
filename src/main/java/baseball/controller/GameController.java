package baseball.controller;

import baseball.model.Compare;
import baseball.model.Computer;
import baseball.model.GameCommand;
import baseball.model.GameStatus;
import baseball.model.Player;
import baseball.model.Result;
import baseball.util.GameStatusHelper;
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
        if (!GameStatus.isApplicationExit(gameStatus)) {
            playSingleGame();
            handleRetry();
            playUntilExit();
        }
    }

    private void playSingleGame() {
        Computer computer = Computer.createByNumber();
        playRound(computer);
        outputView.printThreeStrike();
    }

    private void playRound(Computer computer) {
        if (!GameStatus.isGameOver(gameStatus)) {
            Player player = getPlayerFromInput();
            Result result = compareComputerAndPlayer(computer, player);
            outputView.printGameResult(result);
            updateGameStatus(result);
            playRound(computer);
        }
    }

    private Player getPlayerFromInput() {
        return Player.createByNumber(inputView.readPlayerNumber());
    }

    private Result compareComputerAndPlayer(Computer computer, Player player) {
        Compare compare = Compare.judge(computer, player);
        return compare.ResultgetBallCountJudgement();
    }

    private void updateGameStatus(Result result) {
        gameStatus = GameStatusHelper.fromIsThreeStrike(result.isThreeStrike());
    }

    private void handleRetry() {
        gameStatus = GameStatusHelper.fromSelectedRetry(isSelectedRetry());
    }

    private boolean isSelectedRetry() {
        return GameCommand.from(inputView.readGameCommand()).selectedRetry();
    }

    private void handleException(IllegalArgumentException exception) {
        outputView.printExceptionMessage(exception);
        throw exception;
    }
}

