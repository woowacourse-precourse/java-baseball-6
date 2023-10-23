package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.ComputerBalls;
import baseball.domain.GameStatus;
import baseball.domain.PlayResult;
import baseball.domain.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {
    private final InputView inputView;
    private final OutputView outputView;
    private GameStatus gameStatus;

    public BaseBallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameStatus = GameStatus.PLAY;
    }

    public void play() {
        outputView.printMainMessage();
        playGame();
    }

    private void playGame() {
        while (canPlay()) {
            playSingleGame();
            outputView.printGameEnd();
            gameStatus = GameStatus.from(inputView.readRetryCommand());
        }
    }

    private boolean canPlay() {
        return this.gameStatus.isGameContinue();
    }

    private void playSingleGame() {
        ComputerBalls computer = new ComputerBalls();
        boolean continueGame = true;
        while (continueGame) {
            User user = new User(new Balls(inputView.readUserNumber()));
            PlayResult result = computer.play(user);

            outputView.printResult(result);
            continueGame = !isGameEnd(result);
        }
    }

    private boolean isGameEnd(PlayResult result) {
        return result.isGameEnd();
    }
}
