package baseball.controller;

import static baseball.util.Constants.DEFAULT_VALUE;

import baseball.model.Compare;
import baseball.model.Computer;
import baseball.model.GameCommand;
import baseball.model.GameStatus;
import baseball.model.Player;
import baseball.model.Result;
import baseball.util.GameStatusHelper;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.stream.IntStream;

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

        IntStream.generate(() -> DEFAULT_VALUE)
                .takeWhile(i -> !GameStatus.isApplicationExit(gameStatus))
                .forEach(i -> {
                    playSingleGame();
                    handleRetry();
                });
    }

    private void playSingleGame() {
        Computer computer = Computer.createByNumber();

        IntStream.generate(() -> DEFAULT_VALUE)
                .takeWhile(i -> !GameStatus.isGameOver(gameStatus))
                .forEach(i -> {
                    Player player = getPlayerFromInput();
                    Result result = getResultFromComparison(computer, player);
                    outputView.printGameResult(result);
                    updateGameStatus(result);
                });

        outputView.printThreeStrike();
    }

    private Player getPlayerFromInput() {
        return Player.createByNumber(inputView.readPlayerNumber());
    }

    private Result getResultFromComparison(Computer computer, Player player) {
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

