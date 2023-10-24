package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.RoundResult;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        OutputView.printStartMessage();
        playGame();
    }

    private void playGame() {
        playRounds(gameService.createAnswerBalls());
        endGame();
    }

    private void playRounds(Balls answer) {
        Balls playerBalls = gameService.getPlayerBalls();
        RoundResult roundResult = playerBalls.compareWith(answer);
        OutputView.print(roundResult);
        if (roundResult.isGameEnd()) {
            return;
        }
        playRounds(answer);
    }

    private void endGame() {
        if (InputView.retryOrExit()) {
            playGame();
        }
    }
}